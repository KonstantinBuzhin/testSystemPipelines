package system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Pipeline;

public class PipelineSystem {

	private final Map<Integer, Map<Integer, List<Pipeline>>> system;

	public PipelineSystem(List<Pipeline> pipes) {
		this.system = build(pipes);
	}

	private Map<Integer, Map<Integer, List<Pipeline>>> build(List<Pipeline> pipes) {
		Map<Integer, Map<Integer, List<Pipeline>>> pipelineSystem = new HashMap<Integer, Map<Integer, List<Pipeline>>>();
		for (Pipeline pipe : pipes) {
			Map<Integer, List<Pipeline>> pipeline = pipelineSystem.get(Integer.valueOf(pipe.getIdX()));
			if (pipeline == null) {
				pipeline = new HashMap<Integer, List<Pipeline>>();
				pipelineSystem.put(Integer.valueOf(pipe.getIdX()), pipeline);
			}
			List<Pipeline> pipelineList = pipeline.get(Integer.valueOf(pipe.getIdY()));
			if (pipelineList == null) {
				pipelineList = new ArrayList<Pipeline>();
				pipeline.put(Integer.valueOf(pipe.getIdY()), pipelineList);
			}
			pipelineList.add(pipe);
			for (int key : pipelineSystem.keySet()) {
				if (pipelineSystem.get(key).containsKey(Integer.valueOf(pipe.getIdX()))) {
					List<Pipeline> path = new ArrayList<Pipeline>(
							pipelineSystem.get(key).get(Integer.valueOf(pipe.getIdX())));
					path.add(pipe);
					pipelineSystem.get(key).put(Integer.valueOf(pipe.getIdY()), path);
				}
			}
		}
		return pipelineSystem;
	}

	public Map<Integer, Map<Integer, List<Pipeline>>> system() {
		return system;
	}
}
