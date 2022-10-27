package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("FindByCarMethod")
    public User findByCar(String model, int series) {
        String hql = " FROM Car WHERE model = :paramModel AND series = :paramSeries";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("paramModel", model);
        query.setParameter("paramSeries", series);
        Car car = (Car) query.getSingleResult();
        return car.getOwner();
    }

    @Override
    @SuppressWarnings("value")
    public List<Car> listCars() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("FROM Car");
        return query.getResultList();
    }
}
