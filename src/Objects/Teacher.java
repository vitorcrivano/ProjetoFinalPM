package Objects;

public class Teacher 
{
    private String name;
    private String code;
    private Resume resume;

    public Teacher(String name, String code) 
    {
        this.name = name;
        this.code = code;
        this.resume = new Resume();
    }
    
    public Teacher()
    {
        this("","");
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }
    
    public void setResume(Resume resume)
    {
        this.resume = resume;
    }
    
    public Resume getResume()
    {
        return resume;
    }
}
