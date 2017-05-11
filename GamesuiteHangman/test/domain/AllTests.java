package domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PuntTest.class, SpelerTest.class, CirkelTest.class, RechthoekTest.class, LijnStukTest.class, DriehoekTest.class, TekeningTest.class,
				HangManTest.class, HintLetter.class, HintWoord.class, Omhullende.class, WoordenLijstTest.class})
public class AllTests {

}
