package shaders;

import org.lwjgl.util.vector.Matrix4f;

public class StaticShader extends ShaderProgram {

	private static final String VERTEX_FILE = "src/shaders/vertexShader.txt";
	private static final String FRAGMENT_FILE = "src/shaders/fragmentShader.txt";

	private int location_transformationMatrix;

	public StaticShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void bindAttributes() {
		// TODO Auto-generated method stub
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textureCoords");
	}

	@Override
	protected void getAllUniformLocations() {
		// TODO Auto-generated method stub
		location_transformationMatrix = super.getUniformLocation("transformationMatrix");
	}

	public void loadTransformationmatrix(Matrix4f matrix) {
		super.loadMatrix(location_transformationMatrix, matrix);
	}

}
