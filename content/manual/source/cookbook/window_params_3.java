@WindowParam
private List<UUID> added;

@Override
public void ready() {
    if (added != null && !added.isEmpty()) {
        FilterEntity filterEntity = metadata.create(FilterEntity.class);
        filterEntity.setName("Not added yet");
        filterEntity.setXml("<filter>\n" +
                "  <and>\n" +
                "    <c name=\"id\" class=\"java.util.UUID\" inExpr=\"true\" hidden=\"true\" operatorType=\"NOT_IN\" width=\"1\" type=\"PROPERTY\">" +
                "           <![CDATA[((e.id not in :component$filter.id_list) or (e.id is null)) ]]>\n" +
                "      <param name=\"component$filter.id_list\" javaClass=\"java.util.UUID\">NULL</param>\n" +
                "    </c>\n" +
                "  </and>\n" +
                "</filter>");
        filter.setFilterEntity(filterEntity);
        filter.setParamValue("id_list", added);
        filter.apply(true);
    }
}