# TicTacToe_with_Java
TicTacToe game with Java


## Day 1 of #100DaysOfCode
Goal : Get familiar with Java syntax & Remind basic coding rules to boost my brain for the next projects.
Date: 1/17/2021
Start Time: 2:30pm
End Time: 6:00pm

### New things I have learned 
> 1. How to read Java input - "**use Scanner class!**"
>> import java.util.Scanner;    
>> Scanner scan = new Scanner(System.in);    
>> String str = scan.nextLine();    
>> * Unlike scan.nextLine(), scan.nextInt() does not consume the new line. So, after the scan.nextInt(), scan.nextLine() might be required.



>2. ArrayList<Integer> (O) / ArrayList<int> (X)
  >> To create an arraylist, we use keyword 'Integer' for the primitive 'int' (integer) data type. (can be tricky!!)



>3. How to convert int value to char?
>> int n = 1;
>> char c = (char)(n+'0');

>4. How to create a random number?
>> //random number in range 1 to 9               
>> =>(int)(Math.random()*9)
>> 
>> //get random element in an arraylist                       
>> =>import java.util.Rnadom;                        
>> =>Random random = new Random();                         
>> =>**[ArrayList].get(random.nextInt([ArrayList].size());**         



>5.How to remove an element of an arraylist with the integer value of the element
>> //removing an element by index            
>> =>[ArrayList].remove(index);        
>> //removing an element by integer value          
>> =>[ArrayList].remove(Integer.valueOf(value));           
