import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;

class SecretEntrance {
	int currentDial = 50;
	int zeroCountAfterRotation = 0;
	int zeroCountDuringRotation = 0;
	int getPassword(String path){
	    readFile(path);
	    return  zeroCountAfterRotation +  zeroCountDuringRotation ;
	}

	void leftParser(String instruction){
	        String rotation = instruction.substring(1);
	        int rot = Integer.parseInt(rotation);
		
		currentDial = (currentDial - rot) % 100;
               
		if(currentDial < 0){
		   currentDial += 100;
		}
	      
		
		if (currentDial == 0){
		   zeroCountAfterRotation += 1;
		}	
	}
	void rightParser(String instruction){
	        String rotation = instruction.substring(1);
	        int rot = Integer.parseInt(rotation);
                
		currentDial = (currentDial + rot) % 100;
		
		if (currentDial == 0){
		   zeroCountAfterRotation += 1;
		}	
	}

	int leftZeroCounter(int currentDial , int rotation){
	    int zerCount = 0;
	    for(){
	    
	    }


	}
        
	int rightZeroCounter(int currentDial , int rotation){
	    int zerCount = 0;

	    for(){
	    
	    }


	}
 
	void readFile(String path){
	    try(BufferedReader in = new BufferedReader(new FileReader(path))){
		  String instruction = in.readLine();
		  IO.println("File Reader Started");
		  
		  while(instruction != null ){
		    if(instruction.startsWith("L")){
			    leftParser(instruction);
		    }else{
		            rightParser(instruction);
		    }
		    instruction = in.readLine();
		  }
	    }catch(IOException e){
	          e.printStackTrace();
	    }
	}
       
	void main(){
	   SecretEntrance se = new SecretEntrance();
	   int password = se.getPassword("inputs/test.txt");
	   String strPassword =  String.format("The Password is: %d",password);
	   IO.println(strPassword);
	}
}
