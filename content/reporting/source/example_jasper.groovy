import com.haulmont.cuba.core.global.AppBeans

def persistence = AppBeans.get('cuba_Persistence')
def tx = persistence.createTransaction()
try {
    def result = []

    def em = persistence.getEntityManager()
    def ltList = em.createQuery('select lt from library$LiteratureType lt').getResultList()
    ltList.each { lt ->
        def count = em.createQuery('''
                select count(bi) from library$BookInstance bi 
                where bi.libraryDepartment.id = ?1
                    and bi.bookPublication.book.literatureType.id = ?2
                                    ''')
                .setParameter(1, params['library_department'])
                .setParameter(2, lt)
                .getSingleResult()
        def refCount = em.createQuery('''
                select count(bi) from library$BookInstance bi 
                where bi.libraryDepartment.id = ?1
                    and bi.bookPublication.book.literatureType.id = ?2 and bi.isReference = true''')
                .setParameter(1, params['library_department'])
                .setParameter(2, lt)
                .getSingleResult()

        result.add(['literature_type_name': lt.name,
                    'books_instances_amount': count,
                    'reference_books_instances_amount': refCount])
    }
    return result
} finally {
    tx.end()
}