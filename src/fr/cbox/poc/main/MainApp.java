package fr.cbox.poc.main;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {
	
	public static void main(String[] args) {
		System.out.println("Hello World !");
		
		HeroAssociation ha = new HeroAssociation("Justice League");
		
		
		Class haClass = ha.getClass();
		
		// récupère les propriété de l'objet, même celles private
		Field[] fields = haClass.getDeclaredFields();
		
		for(Field field : fields) {
			field.setAccessible(true);
			System.out.println(field.getName());
			Class<?> fieldClass = field.getType();
			System.out.println(fieldClass.getName());
			
			
			Type type = field.getGenericType();
			
			if ( type instanceof ParameterizedType) {
			
				ParameterizedType pType = (ParameterizedType) type;
				Class<?> stringListClass = (Class<?>) pType.getActualTypeArguments()[0];
				
				System.out.println(stringListClass == Hero.class);
				
				System.out.println(stringListClass.getName()); // class java.lang.String.
				
			}
			
			
			// ParameterizedType stringListType = (ParameterizedType) field.getGenericType();
	        
	        
		}
		
		
	}

}


class HeroAssociation {
	
	
	private String name;
	
	private List<Hero> heroes = new ArrayList<Hero>(
			 Arrays.asList(new Hero("Superman", 100), new Hero("Batman", 99)));
	
	public HeroAssociation(String name) {
		super();
		this.name = name;
	}
	

	public List<Hero> getHeroes() {
		return heroes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}

class Hero {
	
	private String heroName;
	private int level;
	
	
	public Hero(String heroName, int level) {
		super();
		this.heroName = heroName;
		this.level = level;
	}
	
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}		
	
}
