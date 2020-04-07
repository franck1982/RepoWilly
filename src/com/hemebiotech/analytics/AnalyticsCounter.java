package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter implements IAnalyticsCounter{

	/*
	 * remplir un fichier qui contient les symptoms tri�s li�s aux occurences
	 * 
	 */

	public void remplirFichier(String pathResult , Map<String,Integer> mapSymptoms  ) 

	{

       //try-with-ressource pour fermer automatiquement le Writer 
		
		try(FileWriter writer = new FileWriter (pathResult))
		{

			//parcours tous les symptomes dans la Map 
			for(String element:mapSymptoms.keySet())
			{
				//ecrire chaque symptome avec son occurence
				writer.write(element +" : "+mapSymptoms.get(element) + "\n");
				System.out.println(element +" : "+mapSymptoms.get(element));
			}

		} catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		
	

	}

	/*
	 * remplir une Map qui contient les symptoms li�s aux occurences
	 * 
	 */
	public void remplirMap(List<String> liste , Map<String,Integer> mapSymptoms )

	{
		int i =0;
		for(String element:liste)
		{
			i=1;
			if (mapSymptoms.keySet().contains(element))
				//incr�mentez l' occurence du symptome
				i = mapSymptoms.get(element) + 1;
			//mettre � jour l'�l�ment dans la Map avec la nouvelle occurence.
			mapSymptoms.put(element,i);
		}



	}
	@Override
	public void execute(ISymptomReader reader) {
		// TODO Auto-generated method stub
		
	}

}
