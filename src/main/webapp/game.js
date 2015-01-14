var speed = 10;
var actions = [];

function Map(game, tiles, width, height) {
	this.game = game;
	this.tiles = tiles;
	this.width = width;
	this.height = height;
	this.tile_size = (width/tiles.length);
	
	this.render = function render(context) {
		for (var xx = 0; xx < tiles.length; ++xx) {
			for (var yy = 0; yy < tiles[0].length; ++yy) {
				if (tiles[yy][xx] == 0) {
					context.fillStyle = "#EEEEEE";
				} else {
					context.fillStyle = "#00FF00";
				}
				context.fillRect(xx*this.tile_size, yy*this.tile_size, this.tile_size, this.tile_size);
				context.strokeRect(xx*this.tile_size, yy*this.tile_size, this.tile_size, this.tile_size);
			}
		}
	}

	this.update = function update(delta) {

	}
}

function Player(game, x, y) {
	this.x = x;
	this.y = y;
	this.game = game;

	var goToX = x;
	var goToY = y;
	var moving = false;

	this.render = function render(context) {
		context.beginPath();
		context.arc(this.x+this.game.map.tile_size/2, this.y+this.game.map.tile_size/2, this.game.map.tile_size/2 - 4,0 , 2*Math.PI);
		context.fillStyle = "#FF0000";
		context.fill();
	}

	this.update = function update(delta) {
		if (Math.abs(goToX - this.x) > 2) {
			var xsign = 1;
			if (goToX - this.x < 0) xsign = -1;

			this.x += 10 * delta * speed * xsign;
		} else {
			this.x = goToX;
			if (Math.abs(goToY - this.y) > 2) {
				var ysign = 1;
				if (goToY - this.y < 0) ysign = -1;

				this.y += 10 * delta * speed * ysign;
			} else {
				this.y = goToY;
				moving = false;
			}
		}
		
		
	
	}

	this.moveTo = function moveTo(x, y) {
		moving = true;
		goToX = x;
		goToY = y;
	}

	this.moveToTile = function moveToTile(x, y) {
		if (this.game.map.tiles[y][x] != 1) {
			this.moveTo(x * this.game.map.tile_size, y * this.game.map.tile_size);
			return true;
		}
		return false;
	}

	this.tileX = function tileX() {
		return Math.round(this.x/this.game.map.tile_size);
	}

	this.tileY = function tileY() {
		return Math.round(this.y/this.game.map.tile_size);
	}

	this.isDoingSomething = function isDoingSomething() {
		return moving;
	}

	
}


function Game(width, height) {
	this.width = width;
	this.height = height;
	this.tiles = [[2,0,0,0,0],
	     	      [1,1,1,0,0],
                      [1,0,0,0,0],
                      [1,0,1,1,1],
		      [1,0,1,1,1]];


	this.map = new Map(this, this.tiles, this.width, this.height);
	this.player = new Player(this, 0, 0);

	this.render = function render() {
		var c = document.getElementById("enigme");
		var ctx = c.getContext("2d");
		
		this.map.render(ctx);
		this.player.render(ctx);
	}

	this.update = function update(delta) {
		if (actions.length > 0 && !this.player.isDoingSomething()) {
			var arr = actions.shift();
			if (!this.player.moveToTile(this.player.tileX() + arr[0], this.player.tileY() + arr[1])) {
				alert("Collision avec un mur !")
				reset();
			} else {
				addToLog(arr[2]);
			}
		}
		this.map.update(delta);
		this.player.update(delta);
		this.render();
	}
}

var game = new Game(200, 200);

var time;
function mainLoop() {
	requestAnimationFrame(mainLoop);
	var now = new Date().getTime(),
	dt = (now - (time || now))/1000;

	time = now;
	game.update(dt);
}

function addToLog(msg) {
	
	$('#log').scrollTop($('#log')[0].scrollHeight);
	document.getElementById("log").value += msg + "\n";
}

function reset() {
	actions = [];
	// Cherche la position initiale du joueur
	/*
	var initx = 0;
	var inity = 0;
	
	for (var xx = 0; xx < tiles.length; ++xx) {
		for (var yy = 0; yy < tiles[0].length; ++yy) {
			if (tiles[yy][xx] == 2) {
				initx = xx;
				inity = yy;
				break;
			}
		}
	}

	game.player.moveToTile(initx, inity);*/
	
}

//game.player.moveToTile(game.player.tileX()+1, game.player.tileY());

function droite() {actions.push([1, 0, "Déplace vers la droite"])}
function gauche() {actions.push([-1, 0, "Déplace vers la gauche"])}
function bas() {actions.push([0, 1, "Déplace vers le bas"])}
function haut() {actions.push([0, -1, "Déplace vers le haut"])}
//function gauche() {game.player.moveToTile(game.player.tileX()-1, game.player.tileY());}
//function bas() {game.player.moveToTile(game.player.tileX(), game.player.tileY()+1);}
//function haut() {game.player.moveToTile(game.player.tileX()-1, game.player.tileY()-1);}

function executeAlgo() {
	document.getElementById("log").value = "";
	actions = [];
	eval($("#algo").val());
}

mainLoop();




