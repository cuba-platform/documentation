def result = []

transactional { em ->
    def query = em.createQuery('select distinct c.dateOfCall from matrix$Call c order by c.dateOfCall ')
    query.resultList.each { date ->
        def query2 = em.createQuery('select c from matrix$Call c where c.operator.id = ? 1 and c.dateOfCall = ? 2 ')
        query2.setParameter(1, parentBand.getParameterValue('operator_id'))
        query2.setParameter(2, date)
        result.add(['calls': query2.resultList.size()])
    }
}
return result