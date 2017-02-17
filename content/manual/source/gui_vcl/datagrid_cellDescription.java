customersDataGrid.setCellDescriptionProvider((entity,columnId)->{
    if ("name".equals(columnId)||"lastName".equals(columnId)){
        return null;
    }

    String description="<strong>"+
            messages.getTools().getPropertyCaption(entity.getMetaClass(),columnId)+
            ": </strong>";

    if ("grade".equals(columnId)){
        description += messages.getMessage(entity.getGrade());
    } else if ("active".equals(columnId)){
        description += getMessage(entity.getActive() ? "trueString":"falseString");
    } else {
        description += entity.getValue(columnId);
    }
        return description;
});