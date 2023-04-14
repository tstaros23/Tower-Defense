package checkpoint2;

abstract public class GameObject implements Animatable
{
    protected boolean hasExpired;

    public GameObject ()
    {
        hasExpired = false;
    }

    public boolean hasExpired ()
    {
        return hasExpired;
    }
}
