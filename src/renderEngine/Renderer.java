package renderEngine;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class Renderer {

	public void prepare() {
		GL11.glClearColor(1, 0, 0, 1); // RED COLOR
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}
	
	public void render(RawModel model) {
		// 1. Binding VAO
		GL30.glBindVertexArray(model.getVaoID());
		
		// 2. Enable 0 that positions was added by loader.
		GL20.glEnableVertexAttribArray(0);
		
		// 3. Draw
		GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, model.getVertexCount());
		
		// 4. Disable
		GL20.glDisableVertexAttribArray(0);
		GL30.glBindVertexArray(0);
	}
	
}
