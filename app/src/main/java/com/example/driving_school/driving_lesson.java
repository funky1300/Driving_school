package com.example.driving_school;

public class driving_lesson {
    private String name;
    private String phone_number;
    private String email;

    public driving_lesson(String name, String phone_number, String email)
    {
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public String getPhone_number()
    {
        return phone_number;
    }

    public String getEmail()
    {
        return email;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPhone_number(String phone_number)
        {
        this.phone_number = phone_number;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
