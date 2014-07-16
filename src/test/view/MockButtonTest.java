package test.view;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.ButtonStartListener;

public class MockButtonTest {

	@Test
	public void testClick() {
		MockButton btn = new MockButton();
		
		btn.myClick();
		assertEquals(null, btn.chessBoardThread);
		
		btn.setEnabled(true);
		btn.addActionListener(new ButtonStartListener(btn.model));
		
		btn.myClick();
		assertNotEquals(null, btn.chessBoardThread);
		
	}

}
