package engineTester;

import entities.Camera;
import entities.Entity;
import models.RawModel;
import models.TexturedModel;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.OBJLoader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

public class MainGameLoop {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        DisplayManager.createDisplay();

        Loader loader = new Loader();
        // Bind 0 to 'position' and 1 to 'uv'
        StaticShader shader = new StaticShader();
        Renderer renderer = new Renderer(shader);

        // Load data to VAO
        RawModel model = OBJLoader.loadObjModel("stall", loader);
        // Load Texture
        ModelTexture texture = new ModelTexture(loader.loadTexture("stallTexture"));
        TexturedModel texturedModel = new TexturedModel(model, texture);

        Entity entity = new Entity(texturedModel, new Vector3f(0, 0, -50), 0, 0, 0, 1);

        Camera camera = new Camera();

        while (!Display.isCloseRequested()) {
            entity.increaseRotation(0, 0.01f, 0);
            camera.move();
            renderer.prepare();
            // game logic
            // render
            shader.start();
            shader.loadViewMatrix(camera);
            renderer.render(entity, shader);
            shader.stop();
            DisplayManager.updateDisplay();
        }

        shader.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();

    }

}
