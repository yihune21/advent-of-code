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
	    return  zeroCountDuringRotation + zeroCountAfterRotation;
	}

	void leftParser(String instruction){
	        String rotation = instruction.substring(1);
	        int rot = Integer.parseInt(rotation);

		zeroCountDuringRotation += leftZeroCounter(currentDial , rot);

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

		zeroCountDuringRotation += rightZeroCounter(currentDial , rot);
		currentDial = (currentDial + rot) % 100;
		
		if (currentDial == 0){
		   zeroCountAfterRotation += 1;
		}	
	}

	int leftZeroCounter(int currentDial , int rotation){
	    int zeroCount = 0;
	    for(int i = 1; i < rotation ;i++){
	          currentDial = (currentDial - 1 ) % 100;
		  if(currentDial < 0 ){
		     currentDial = currentDial % 100;
		     if (currentDial < 0) {
		        currentDial += 100;
		     }
		  }

		  if(currentDial == 0){
			  zeroCount += 1;
		  } 
	    }

            return zeroCount;
	}
        
	int rightZeroCounter(int currentDial , int rotation){
	    int zeroCount = 0;
	    for(int i = 1; i < rotation;i++){
	          currentDial = currentDial + 1;
		  if(currentDial > 99){
		     currentDial  = currentDial % 100;
		  }
		  if(currentDial == 0){
			zeroCount += 1;
		  } 
	    }

	    return zeroCount;
            
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
	   int password = se.getPassword("inputs/day-01.txt");
	   String afterCounter = String.format("Zero After Rotation : %d",se.zeroCountAfterRotation);
           String duringCounter = String.format("Zero During Rotation : %d",se.zeroCountDuringRotation);

          IO.println(afterCounter);
	  IO.println(duringCounter);
	   String strPassword =  String.format("The Password is: %d",password);
	   IO.println(strPassword);


	}
}
