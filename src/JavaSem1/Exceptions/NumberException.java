package Exceptions;

class  NumberException extends Exception
{
    /**
     * Constructs an NumberException with no detail message
     */
    public NumberException()	{
        super();
    }

    /**
     * Constructs an NumberException with Number.Exception detail message
     *
     ** @param    s    the detail message.
     */
    public NumberException(String s)	{
        super(s);
    }
}
