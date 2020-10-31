package kimmel.business.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kimmel.business.Grade;

class GradeTest {

	@Test
	void testLetterGradeA() {
		Grade gradeA = new Grade(88);

		assertEquals("A", gradeA.getLetter());

	}

	@Test
	void testLetterGradeF() {
		Grade gradeF = new Grade(50);

		assertEquals("F", gradeF.getLetter());

	}

}
