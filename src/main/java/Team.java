import java.util.ArrayList;
import java.util.List;


public class Team {
  private String mNameofTeam;
  private static List<Team> instances = new ArrayList<Team>();
  private int mId;
  private List<Member> mTeams;

  public Team(String nameOfTeam) {
    mNameofTeam = nameOfTeam;
    instances.add(this);
    mId = instances.size();
    mTeams = new ArrayList<Member>();
  }

  public String getName() {
    return mNameofTeam;
  }

  public static List<Team> all() {
     return instances;
  }

  public static void clear() {
   instances.clear();
  }

  public int getId()  {
    return mId;
  }

  public static Team find(int id) {
   return instances.get(id - 1);
  }

  public List<Member> getMembers()  {
    return mTeams;
  }

  public void addMember(Member Member)  {
    mTeams.add(Member);
  }
}
