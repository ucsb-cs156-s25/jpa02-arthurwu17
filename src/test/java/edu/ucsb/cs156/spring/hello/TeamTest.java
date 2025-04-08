package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same_object() {
        assertTrue(team.equals(team), "Equals fails for Same Object");
    }

    @Test
    public void equals_different_object() {
        String s = "This is not a Team Object";
        assertTrue(!team.equals(s), "Equals fails for Different Object");
    }

    @Test
    public void equals_name_and_members_true() {
        team.addMember("Arthur");
        team.addMember("Simon");
        Team team2 = new Team("test-team");
        team2.addMember("Arthur");
        team2.addMember("Simon");
        assertTrue(team.equals(team2), "Equals fails for Teams same name same members");
    }

    @Test
    public void equals_name_true_members_false() {
        team.addMember("Arthur");
        team.addMember("Simon");
        Team team2 = new Team("test-team");
        assertTrue(!team.equals(team2), "Equals fails for Teams same name different members");
    }

    @Test
    public void equals_name_false_members_true() {
        team.addMember("Arthur");
        team.addMember("Simon");
        Team team2 = new Team("test-team2");
        team.addMember("Arthur");
        team.addMember("Simon");
        assertTrue(!team.equals(team2), "Equals fails for Teams different name same members");
    }

    @Test
    public void equals_name_false_members_false() {
        team.addMember("Arthur");
        team.addMember("Simon");
        Team team2 = new Team("test-team2");
        assertTrue(!team.equals(team2), "Equals fails for Teams different name different members");
    }

    @Test
    public void hashCode_equal_test() {
        Team t = new Team();
        t.addMember("foo");
        t.addMember("bar");
        int expected = 3247054; // Overspecifying requirements
        assertEquals(expected, t.hashCode());
    }
}
