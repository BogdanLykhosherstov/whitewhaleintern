import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
public class gibgen {
	public String SrcabmlingTmie(String text){
		String newText = "";
		
		Deque <String> oddChars =new LinkedList<String>();
		Deque <String> evenChars = new LinkedList<String>();
		//check entire string	
		String[] subStrings= text.split("[[“]*|[”]*|[-]*|[–,),(]*|[;]*|[\"]*|[ ]*|[,]*|[\\.]*|[:]*|[/]*|[!]*|[?]*|[+]*|[=]*]+");
		String[] subPunctuations = text.split("[[\']|[0-9]|[a-zA-Z]]+");
		List<String> stringList = new ArrayList<String>(Arrays.asList(subStrings)); 
		List<String> puncList = new ArrayList<String>(Arrays.asList(subPunctuations));
		//tiny bug fix
		if(!(puncList.isEmpty())){
			puncList.remove(0);
		}
		for(int j=0; j<stringList.size();j++){
			//if <=3 just add the word, then punc after it(if exists)
			if(stringList.get(j).length()<=3 || Character.isDigit(stringList.get(j).charAt(0))){
				newText+=stringList.get(j);
				if(!(puncList.isEmpty())){
					newText+=puncList.get(0);
					puncList.remove(0);
				}
				continue;
			}		
			//substring is being delimited by a punctuation to be used by the inner for loop for scrambling one substring at a time	
			//checks 1 word at a time
			else{
				
				text = stringList.get(j);
				int textLength = text.length();
				//in case it has an apostrophe
				if (text.contains("\'")){
					textLength--;
				}
				Character currentChar1 = text.charAt(0);
				newText+=currentChar1.toString();
				for(int i=1; i<textLength-1;i++){
					Character currentChar = text.charAt(i);
	
					//if uppercase, it implies abbreviation, so skip to next iteration
					if(Character.getType(currentChar)==Character.UPPERCASE_LETTER){
						newText+=currentChar.toString();
						continue;
					}
					
					//if lowercase, begin scrambling
					else{
						if(i%2==0){
							oddChars.add(currentChar.toString());
						}
						else{
							evenChars.add(currentChar.toString());
						}
					}
					
				}
				//take every even char and place it first before odd chars
				while((!(oddChars.isEmpty()))||(!(evenChars.isEmpty()))){
					if(oddChars.isEmpty()){
						newText+=evenChars.pop();
						continue;
					}
					if(evenChars.isEmpty()){
						newText+=oddChars.pop();
						continue;
					}
					newText+=oddChars.pop();
					newText+=evenChars.pop();					
				}
			}
			//in case it has an apostrophe
			if (text.contains("\'")){
				newText+="'";
			}
			Character lastChar =text.charAt(text.length()-1);
			newText+= lastChar.toString();
			if(!(puncList.isEmpty())){
				newText+=puncList.get(0);
				puncList.remove(0);
			}
		}
		return newText;
	}
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		gibgen driver = new gibgen();
		String text = "";
		String input= args[0];
		    if (input.equals("text.txt")){
		          
		        try(BufferedReader reader = new BufferedReader(new FileReader(input))) {
		            StringBuilder builder = new StringBuilder();
		            String line = reader.readLine();

		            while (line != null) {
		                builder.append(line);
		                builder.append(System.lineSeparator());
		                line = reader.readLine();
		            }
		          text = builder.toString();		          
				  System.out.println(driver.SrcabmlingTmie(text));
		        }
		       
		    }   
		    else{	    	
		    text= input; 		
			System.out.println(driver.SrcabmlingTmie(text));
		  }					
	}
}
