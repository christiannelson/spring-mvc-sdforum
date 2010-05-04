package xian.recipes.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.concurrent.atomic.AtomicLong;

public class User
{
    public Long id;

    @NotEmpty
    public String email;

    @NotEmpty
    public String name;

    private static final AtomicLong idSequence = new AtomicLong();

    public User() { }

    public User(String email, String name)
    {
        this.email = email;
        this.name = name;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long assignId()
    {
        this.id = idSequence.incrementAndGet();
        return id;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public static User newUser(String email, String name)
    {
        return new User(email, name);
    }
}
