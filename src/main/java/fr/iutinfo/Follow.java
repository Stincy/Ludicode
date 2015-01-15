package fr.iutinfo;

public class Follow {
	private UserData follower;
	private UserData followed;
	
	public Follow(UserData follower, UserData following){
		this.setFollower(follower);
		this.setFollowing(following);
	}
	
	public Follow(){
		
	}

	public UserData getFollower() {
		return follower;
	}

	public void setFollower(UserData follower) {
		this.follower = follower;
	}

	public UserData getFollowing() {
		return followed;
	}

	public void setFollowing(UserData following) {
		this.followed = following;
	}
	
	public String toString(){
		return follower.getPseudo()+" suit "+followed.getPseudo();
	}
}
