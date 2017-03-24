import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class MemberTest {
  @After
  public void tearDown()  {
    Member.clear();
  }
  @Test
  public void Member_actualyInstantiates_true() {
    Member myMember = new Member("Liam");
    assertEquals(true, myMember instanceof Member);
  }

  @Test
  public void Member_instantiatesWithDescription_String() {
    Member myMember = new Member("Liam");
    assertEquals("Liam", myMember.getName());
  }
  @Test
  public void getCreatedAt_instantiatesWithCurrentTime_today() {
    Member myMember = new Member("Liam");
    assertEquals(LocalDateTime.now().getDayOfWeek(), myMember.getCreatedAt().getDayOfWeek());
  }
  @Test
  public void all_returnsAllInstancesOfMember_true() {
    Member firstMember = new Member("Liam");
    Member secondMember = new Member("Oli");
    assertEquals(true, Member.all().contains(firstMember));
    assertEquals(true, Member.all().contains(secondMember));
  }
  @Test
  public void getId_MembersInstantiateWithAnID_1() {
    Member.clear();
    Member myMember = new Member("Liam");
    assertEquals(1, myMember.getId());
  }
  @Test
  public void find_returnsMemberWithSameId_secondMember() {
    Member firstMember = new Member("Liam");
    Member secondMember = new Member("Oli");
    assertEquals(Member.find(secondMember.getId()), secondMember);
  }

}
