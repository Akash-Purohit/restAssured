package runProgram;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.embedder.Embedder;

import com.integrated.utils.restapi.JsonUtil;
import com.integrated.utils.steps.restResponse;

public class runProgram {
	private static Embedder embedder = new Embedder();
	private static List<String> storyPaths = Arrays
			.asList("stories/restAssured.story");

	public static void main(String[] args) {
		embedder.candidateSteps().add(new JsonUtil());
		embedder.candidateSteps().add(new restResponse());
		embedder.runStoriesAsPaths(storyPaths);
	}
}