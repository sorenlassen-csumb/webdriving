# webdriving
WebDriver examples

Find a $URL with a Facebook login button. Then run FacebookLogin example with (substituting your test user email and password for $TESTUSER and $TESTPASSWORD):

mvn compile exec:java -Dfblogin.test.email=$TESTUSER -Dfblogin.test.password=$TESTPASSWORD -Dexec.mainClass=edu.csumb.cst438fa16.webdriving.FacebookLogin -Dexec.args="$URL"

all on one line
