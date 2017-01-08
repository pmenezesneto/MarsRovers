package Classes;

/**
 *
 * @author Pedro Severino de Menezes Neto
 */

public class Rovers {
    
    //<editor-fold defaultstate="collapsed" desc="Attributes and properties">
    
    private int coordinateX, coordinateY;
    private char position;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Builder">
    
    public Rovers(int coordinateX, int coordinateY, char position)
    {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.position = position;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    
    public char getPosition()
    {
        return this.position;
    }
    
    public void setPosition(char position)
    {
        this.position = position;
    }
    
    public int getCoordinateX() {
        return coordinateX;
    }
    
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }
    
    public int getCoordinateY() {
        return coordinateY;
    }
    
    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
    
    public void Move()
    {
        if(this.getPosition() == 'N')
        {
            this.setCoordinateY(this.getCoordinateY() + 1);
        }
        else
        {
            if(this.getPosition() == 'S')
            {
                this.setCoordinateY(this.getCoordinateY() - 1);
            }
            else
            {
                if(this.getPosition() == 'E')
                {
                    this.setCoordinateX(this.getCoordinateX() + 1);
                }
                else
                {
                    this.setCoordinateX(this.getCoordinateX() - 1);
                }
            }
        }
    }
    
    public void controlPosition(char rotation)
    {
        if (rotation == 'L')
        {
            if(this.getPosition() == 'N')
            {
                this.setPosition('W');
            }
            else
            {
                if(this.getPosition() == 'W')
                {
                    this.setPosition('S');
                }
                else
                {
                    if(this.getPosition() == 'S')
                    {
                        this.setPosition('E');
                    }
                    else
                    {
                        this.setPosition('N');
                    }
                }
            }
        }
        else
        {
            if(this.getPosition() == 'N')
            {
                this.setPosition('E');
            }
            else
            {
                if(this.getPosition() == 'W')
                {
                    this.setPosition('N');
                }
                else
                {
                    if(this.getPosition() == 'S')
                    {
                        this.setPosition('W');
                    }
                    else
                    {
                        this.setPosition('S');
                    }
                }
            }
        }
    }
    
    public String Output()
    {
        return(this.getCoordinateX() + " " + this.getCoordinateY() + " " + this.getPosition());
    }
    //</editor-fold>
    
}
