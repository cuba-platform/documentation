import com.haulmont.cuba.core.Persistence
import com.haulmont.cuba.core.global.AppBeans
import com.haulmont.refapp.core.entity.Colour
import groovy.sql.Sql

log.info('Executing actions in update phase')

Sql sql = new Sql(ds)
sql.execute """
alter table MY_COLOR add DESCRIPTION varchar(100);
"""

// Add post update action
postUpdate.add({
    log.info('Executing post update action using fully functioning server')

    def p = AppBeans.get(Persistence.class)
    def tr = p.createTransaction()
    try {
        def em = p.getEntityManager()

        Colour c = new Colour()
        c.name = 'yellow'
        c.description = 'a description'

        em.persist(c)
        tr.commit()
    } finally {
        tr.end()
    }
})