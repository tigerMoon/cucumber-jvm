package cucumber.runtime;

import cucumber.api.Scenario;
import gherkin.GherkinDialect;
import gherkin.pickles.PickleStep;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class AmbiguousStepDefinitionMatchsTest {
    public final AmbiguousStepDefinitionsException e = mock(AmbiguousStepDefinitionsException.class);
    public final AmbiguousStepDefinitionsMatch match = new AmbiguousStepDefinitionsMatch(mock(PickleStep.class), e);

    @Test
    public void throws_ambiguous_step_definitions_exception_when_run() {
        try {
            match.runStep(mock(GherkinDialect.class), mock(Scenario.class));
            fail("AmbiguousStepDefinitionsException expected");
        } catch (Throwable thrown) {
            assertEquals(e, thrown);
        }
    }

    @Test
    public void throws_ambiguous_step_definitions_exception_when_dry_run() {
        try {
            match.dryRunStep(mock(GherkinDialect.class), mock(Scenario.class));
            fail("AmbiguousStepDefinitionsException expected");
        } catch (Throwable thrown) {
            assertEquals(e, thrown);
        }
    }
}