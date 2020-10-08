package startApp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.opencsv.CSVWriter;
import dbworker.DBWorker;
import mapper.Mapper;
import model.Pipeline;
import model.Route;
import system.PipelineSystem;

public class App {

	public static void main(String[] args) {

		Mapper mapperFiles = new Mapper();

		List<Pipeline> listPipelines = mapperFiles.mapDescriber();

		for (Pipeline pipeline : listPipelines) {
			System.out.println(pipeline);
		}
		System.out.println();

		List<Route> listRoutes = mapperFiles.mapSetter();

		for (Route route : listRoutes) {
			System.out.println(route);
		}
		System.out.println();

		PipelineSystem pipelineSystem = new PipelineSystem(listPipelines);

		for (Entry<Integer, Map<Integer, List<Pipeline>>> entry : pipelineSystem.system().entrySet()) {
			System.out.print(entry.getKey() + " ");
			System.out.print(entry.getValue());
			System.out.println();

		}

		System.out.println();

		createOutputFile(listRoutes, pipelineSystem);

		System.out.println();

		DBWorker dbWorker = new DBWorker();

		if (dbWorker.insertDB(1, "describer.csv") && dbWorker.insertDB(2, "setter.csv")) {
			System.out.println("Insert describer.csv and setter.csv");
		}

	}

	public static void createOutputFile(List<Route> listRoutes, PipelineSystem pipelineSystem) {
		CSVWriter writer;
		try {
			writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream("output.csv"), StandardCharsets.UTF_8),
					';', CSVWriter.DEFAULT_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER,
					CSVWriter.DEFAULT_LINE_END);

			String[] entries = "ROUTE EXISTS,MIN LENGTH".split(",");
			writer.writeNext(entries);

			for (Route route : listRoutes) {

				for (Integer externalKey : pipelineSystem.system().keySet()) {

					if (Integer.valueOf(route.getIdA()).equals(externalKey)) {
						if (pipelineSystem.system().get(externalKey).containsKey(Integer.valueOf(route.getIdB()))) {
							System.out.print("Route exists " + externalKey + ":" + route.getIdB());

							int sum = 0;
							for (Entry<Integer, List<Pipeline>> entry : pipelineSystem.system().get(externalKey)
									.entrySet()) {
								sum = 0;
								for (Pipeline p : entry.getValue()) {

									sum += Integer.valueOf(p.getLength());
								}

							}
							System.out.println(" Min Length=" + sum);
							String result = "TRUE," + sum;
							entries = result.split(",");
							writer.writeNext(entries);

						} else {
							System.out.println("Doesn`t exist");

							entries = "FALSE".split(",");
							writer.writeNext(entries);
						}

					}

				}
			}

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
