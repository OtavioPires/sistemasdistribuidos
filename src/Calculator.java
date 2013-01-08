public class Calculator{ 
	float result;
	
	public String calcule(float n1, float n2, char operator){
		//System.out.println(n1 + " " + n2 + op);
		
        switch(operator){    
        case '+':
        	result = (n1+n2);
        	break;
        case '-':
        	//System.out.println(op);
        	result = (n1-n2);
        	break;
        case '*':
        	result = (n1*n2);
        	break;
        case '/':
        	result = (n1/n2);
        	break;
        default:
        	System.out.println("Operador inválido, utilize +, -, * ou /");
        	break;
        }
    
        return(Float.toString(result));
    
	}
	
	
	

 }