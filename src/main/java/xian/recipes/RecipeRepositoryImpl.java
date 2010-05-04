package xian.recipes;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xian.recipes.model.Recipe;

import java.util.List;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository
{
    private final SessionFactory sessionFactory;

    @Autowired
    public RecipeRepositoryImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public Recipe find(long id)
    {
        return (Recipe) getSession().createQuery("from Recipe where id = :id").setLong("id", id).uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Recipe> find()
    {
        return getSession().createQuery("from Recipe").list();
    }

    @Override
    @Transactional
    public void save(Recipe recipe)
    {
        getSession().save(recipe);
    }

    @Override
    @Transactional
    public void merge(Recipe recipe)
    {
        getSession().merge(recipe);
    }

    @Override
    @Transactional
    public void update(Recipe recipe)
    {
        getSession().update(recipe);
    }

    @Override
    @Transactional
    public void destroy(Recipe recipe)
    {
        getSession().delete(recipe);
    }

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
}
