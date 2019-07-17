package works.buddy.samples;

import com.diffblue.deeptestutils.Reflector;
import com.diffblue.deeptestutils.mock.DTUMemberMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import works.buddy.samples.WorksWithHerokuServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.management.*"})
public class WorksWithHerokuServletDiffblueTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  /* testedClasses: WorksWithHerokuServlet */
  // Test written by Diffblue Cover.
  @PrepareForTest(WorksWithHerokuServlet.class)
  @Test
  public void constructorOutputVoid() throws Exception {

    // Setup mocks
    PowerMockito.suppress(PowerMockito.constructorsDeclaredIn(HttpServlet.class));

    // Act, creating object to test constructor
    final WorksWithHerokuServlet objectUnderTest = new WorksWithHerokuServlet();

    // Method returns void, testing that no exception is thrown
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({WorksWithHerokuServlet.class, HttpServletResponse.class, PrintWriter.class})
  @Test
  public void doGetInputNotNullNotNullOutputVoid()
      throws Exception, InvocationTargetException, ServletException, IOException {

    // Arrange
    final WorksWithHerokuServlet objectUnderTest = new WorksWithHerokuServlet();
    final HttpServletRequest request = PowerMockito.mock(HttpServletRequest.class);
    final HttpServletResponse response = PowerMockito.mock(HttpServletResponse.class);
    final PrintWriter printWriter = PowerMockito.mock(PrintWriter.class);
    Reflector.setField(printWriter, "out", null);
    Reflector.setField(printWriter, "lock", 0);
    Reflector.setField(printWriter, "writeBuffer", null);
    final Method getWriterMethod = DTUMemberMatcher.method(HttpServletResponse.class, "getWriter");
    PowerMockito.doReturn(printWriter).when(response, getWriterMethod).withNoArguments();

    // Act
    objectUnderTest.doGet(request, response);

    // Method returns void, testing that no exception is thrown
  }
}
