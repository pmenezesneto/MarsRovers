package Controller;

import Classes.Rovers;
import Library.Util;

/**
 *
 * @author Pedro Severino de Menezes Neto
 */

public class ControlMarsRovers {
    
    //<editor-fold defaultstate="collapsed" desc="Attributes and Properties">
    //new rover
    private Rovers rover;
    //variables to get coordinate x and y
    private int coordinateX, coordinateY;
    //variable to get the position
    private char position;
    //a char array to get the instructions
    private char[] instructions;
    //variable to use the library, to check if a caracter is a number
    private final Util util = new Util();
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    //check if the position field have correct values
    public boolean CheckFieldPosition(String position)
    {
        if(position.length() != 5)
        {
            return false;
        }
        else
        {
            char firstCaracter = position.charAt(0);
            char secondCaracter = position.charAt(1);
            char thirdCaracter = position.charAt(2);
            char fourthCaracter = position.charAt(3);
            char fifthCaracter = position.charAt(4);
            if(util.checaNumero(firstCaracter) && util.checaNumero(thirdCaracter))
            {
                if(secondCaracter == ' ' && fourthCaracter == ' ')
                {
                    return (fifthCaracter == 'N' || fifthCaracter == 'S' || fifthCaracter == 'E' || fifthCaracter == 'W');
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
    }
    
    //check if the instruction field have correct values
    public boolean CheckFieldInstruction(String instruction)
    {
        if(instruction.length() < 1)
        {
            return false;
        }
        else
        {
            boolean result = false;
            for(int i=0; i< instruction.length(); i++)
            {
                char current = instruction.charAt(i);
                result = !(current != 'L' && current != 'R' && current != 'M');
            }
            return result;
        }
    }
    
    //Instance a new Rover
    public boolean InstanceRover(String position)
    {
        if(CheckFieldPosition(position))
        {
            coordinateX = Integer.parseInt(position.substring(0, 1));
            coordinateY = Integer.parseInt(position.substring(2, 3));
            this.position = position.charAt(4);
            rover = new Rovers(this.coordinateX, this.coordinateY, this.position);
            return true;
        }
        else
            return false;
    }
    
    //Execute the instructions
    public void ExecuteInstructions(String instructions)
    {
        //instance a new array of char to instructions
        this.instructions = new char[instructions.length()];
        
        //populate the char array
        for(int i=0; i<instructions.length();i++)
        {
            this.instructions[i] = instructions.charAt(i);
        }
        
        //runs the instruction array by executing them
        for(int i=0; i<this.instructions.length;i++)
        {
            if(this.instructions[i] != 'M')
            {
                rover.controlPosition(this.instructions[i]);
            }
            else
            {
                rover.Move();
            }
        }
        
        rover.Output();
    }    
    
    //Method to print a string with the result, after the instructions be executed
    public String Output()
    {
        return rover.Output();
    }
    
    //</editor-fold>    
    
}
