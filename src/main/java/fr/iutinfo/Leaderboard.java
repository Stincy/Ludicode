package fr.iutinfo;

import java.awt.List;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class Leaderboard {
	private Map<String,Integer> leaderboard = new HashMap<String,Integer>();
	
	/*public void ajouter(String pseudo, int score){
		if(leaderboard.isEmpty()){
			leaderboard.put(pseudo, score);
		}else{
			for(int i=0;i<leaderboard.size();i++){
				if(leaderboard.get(i).compareTo(score)>0){
					
				}
			}
		}
	}*/
	
	private void sort(Map<String,Integer> l) {
		sortByComparator(l);
	}
		
	private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap) {
		 
		// Convert Map to List
		LinkedList<Entry<String, Integer>> list = 
			new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());
 
		// Sort list with comparator, to compare the Map values
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1,
                                           Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
 
		// Convert sorted map back to a Map
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext();) {
			Map.Entry<String, Integer> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
	
	public void afficher(){
		System.out.println(leaderboard.toString());
		sort(leaderboard);
		System.out.println(leaderboard.toString());
		
	}
}
