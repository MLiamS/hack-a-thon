import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {
  @After
  public void tearDown()  {
    Team.clear();
  }
  @Test
  public void Team_actualyInstantiates_true() {
    Team testTeam = new Team("ATeam");
    assertEquals(true, testTeam instanceof Team);
  }

  @Test
  public void getName_TeamInstantiatesWithName_ATeam() {
    Team testTeam = new Team("ATeam");
    assertEquals("ATeam", testTeam.getName());
  }

  @Test
  public void all_returnsAllInstancesOfTeam_true() {
    Team firstTeam = new Team("ATeam");
    Team secondTeam = new Team("BTeam");
    assertEquals(true, Team.all().contains(firstTeam));
    assertEquals(true, Team.all().contains(secondTeam));
  }
  @Test
  public void clear_emptiesAllCategoriesFromList_0() {
    Team testTeam = new Team("ATeam");
    Team.clear();
    assertEquals(Team.all().size(), 0);
  }

  @Test
  public void getId_categoriesInstantiateWithAnId_1() {
    Team testTeam = new Team("ATeam");
    assertEquals(1, testTeam.getId());
  }


  @Test
  public void find_returnsTeamWithSameId_secondTeam() {
    // Team.clear();
    Team firstTeam = new Team("ATeam");
    Team secondTeam = new Team("BTeam");
    assertEquals(Team.find(secondTeam.getId()), secondTeam);
  }
  @Test
  public void getMembers_initiallyReturnsEmptyList_ArrayList() {
    // Team.clear();
    Team testTeam = new Team("ATeam");
    assertEquals(0, testTeam.getMembers().size());
  }
  @Test
  public void addMember_addsMemberToList_true() {
    Team testTeam = new Team("ATeam");
    Member testMember = new Member("Mow the lawn");
    testTeam.addMember(testMember);
    assertTrue(testTeam.getMembers().contains(testMember));
  }


}
