import java.text.SimpleDateFormat

def simpleOldDateFormat = new SimpleDateFormat('yyyy-MM-dd HH:mm')
def simpleNewDateFormat = new SimpleDateFormat('dd/MM/yyyy HH:mm')
def oldDate = simpleOldDateFormat.parse(value)

return simpleNewDateFormat.format(oldDate)