package ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import dataStructures.Edge;
import dataStructures.Vertex;
import exceptions.EmptyQueueException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import model.TravelGuide;

public class economictravelGUI {

	private TravelGuide tg;

	@FXML
	private BorderPane basePane;

	@FXML
	private AnchorPane map;
	@FXML
	private ImageView caliMap;

	@FXML
	private Circle parquedelasaludV;

	@FXML
	private Circle platillosVoladoresV;

	@FXML

	private Circle unicentroV;
	@FXML
	private Circle jardinPlazaV;

	@FXML
	private Circle monumentoALaAviacionV;

	@FXML
	private Circle pascualGuerreroV;

	@FXML
	private Circle unidaddeportivaV;

	@FXML
	private Circle plazadetoroscañaveralejoV;

	@FXML
	private Circle hospitaluniversitarioV;

	@FXML
	private Circle iglesiaSanfranciscoV;

	@FXML
	private Circle catedralsanpedroV;
	@FXML
	private Circle elbochincheV;

	@FXML
	private Circle museocienciasnaturalesV;

	@FXML
	private Circle lomadelacruzV;

	@FXML
	private Circle gobernaciondelValleV;

	@FXML
	private Circle bibliotecaJoseGarcesV;

	@FXML
	private Circle museolamercedV;

	@FXML
	private Circle centroculturadecaliV;

	@FXML
	private Circle museodelorocalimaV;

	@FXML
	private Circle parquedelospoetasV;

	@FXML
	private Circle bulevardelrioV;

	@FXML
	private Circle teatromunicipalV;

	@FXML
	private Circle iglesialaermitaV;

	@FXML
	private Circle plazaCaycedoV;

	@FXML
	private Circle monumentoamariamulataV;

	@FXML
	private Circle zoologicodecaliV;

	@FXML
	private Circle museodelatertuliaV;

	@FXML
	private Circle sebastiandebelalczararV;

	@FXML
	private Circle hoteldanncarlton;

	@FXML
	private Circle elgatodelrioV;

	@FXML
	private Circle hotelintercontinentalV;

	@FXML
	private Circle cristoReyV;

	@FXML
	private Circle monumentoAlDeporteV;

	@FXML
	private Circle monumentoalasolidaridadempresarialV;

	@FXML
	private Circle chipichapeV;

	@FXML
	private Circle acuaparquedelacañaV;

	@FXML
	private Circle elplanetarioV;

	@FXML
	private Circle hoteltorredecaliV;

	@FXML
	private Circle miradortrescrucesV;
	@FXML
	private Circle jairoVarelaV;
	@FXML
	private Circle camV;
	@FXML
	private Circle iglesiaSanAntonioV;
	@FXML
	private TableView<Vertex> PlacesTable;

	@FXML
	private TableColumn<Vertex, String> Fr;

	@FXML
	private Label fromplacelabel;

	@FXML
	private Label toplacelabel;
	@FXML
	private Label restrictionOptionLabel;
	ImageView imav;
	Image i;
	File f;
	@FXML
	private ComboBox<String> searchOptionComboBox;

	@FXML
	private ComboBox<String> restrictionComboBox;
	@FXML
	private TextField limittxt;

	@FXML
	private Label limitlabel;

	@FXML
	private Label youcantlabel;

	@FXML
	private ColorPicker routecolor;
	@FXML
	private Label youcanlabel;

	Label start;
	Label end;

	//constantes con las rutas de las imagenes de cada lugar
	private static String ACUAPARQUE = "imagenes\\acuaparque.jpg";
	private static String BIBLIOTECAJORGEGARCES = "imagenes\\bibliotecajorgegarces.jpg";
	private static String BULEVARDELRIO = "imagenes\\bulevardelrio.jpeg";
	private static String CAM = "imagenes\\cam.jpg";
	private static String CATEDRALMETROPOLITANA = "imagenes\\catedralmetropolitana.jpg";
	private static String CENTROCULTURALCALI = "imagenes\\centroculturalcali.jpg";
	private static String CHIPICHAPE = "imagenes\\chipichape.jpg";
	private static String CRISTOREY = "imagenes\\cristorey.jpg";
	private static String ELBOCHINCHE = "imagenes\\elbochinche.jpg";
	private static String ELGATODELRIO = "imagenes\\elgatodelrio.jpeg";
	private static String ELPLANETARIO = "imagenes\\elplanetario.jpg";
	private static String GOBERNACIONDELVALLE = "imagenes\\gobernaciondelvalle.jpg";
	private static String HOSPITALUNIVERSITARIO = "imagenes\\hospitaluniversitario.jpg";
	private static String HOTELDARNNCARLTON = "imagenes\\hoteldarnncarlton.jpg";
	private static String HOTELINTERCONTINENTAL = "imagenes\\hotelintercontinental.jpg";
	private static String HOTELTORREDECALI = "imagenes\\hoteltorredecali.jpg";
	private static String IGLESIASANANTONIO = "imagenes\\iglesiasanantonio.jpg";
	private static String IGLESIASANFRANCISCO = "imagenes\\iglesiasanfrancisco.jpg";
	private static String JARDINPLAZA = "imagenes\\jardinplaza.jpg";
	private static String LAERMITA = "imagenes\\laermita.jpeg";
	private static String LOMADELACRUZ = "imagenes\\lomadelacruz.jpg";
	private static String MIRADORTRESCRUCES = "imagenes\\miradortrescruces.jpg";
	private static String MONUMENTOALAVIACION = "imagenes\\monumentoalaaviacion.jpg";
	private static String MONUMENTOALAMARIA = "imagenes\\monumentoalamariamulata.jpg";
	private static String MONUMENTOALASOLIDARIDAD = "imagenes\\monumentoalasolidaridad.jpg";
	private static String MONUMENTOALDEPORTE = "imagenes\\monumentoaldeporte.png";
	private static String MONUMENTOASEBASTIAN = "imagenes\\monumentosebastiandebelalcazar.jpg";
	private static String MUSEOARQUEOLOGICO = "imagenes\\museoarqueologicolamerced.jfif";
	private static String MUSEODELORO = "imagenes\\museodelorocalima.jpg";
	private static String MUSEODEPARTAMENTALCIENCIA = "imagenes\\museodepartamentalcienciasnaturales.jpg";
	private static String MUSEOTERTULIA = "imagenes\\museolatertulia.jpg";
	private static String PARQUEDELASALUD = "imagenes\\parquedelasalud.jpg";
	private static String PARQUEDELOSPOETAS = "imagenes\\parquedelospoetas.jpg";
	private static String PASCUALGUERRERO = "imagenes\\pascual guerrero.jpg";
	private static String PLAZACAICEDO = "imagenes\\plazacaicedo.jpg";
	private static String PLAZADETOROS = "imagenes\\plazadetoroscañaveralejo.jpg";
	private static String JAIROVARELA = "imagenes\\plazoletajairovarela.jpeg";
	private static String TEATROMUNICIPAL = "imagenes\\teatromunicipal.jpg";
	private static String UNICENTRO = "imagenes\\unicentro.jpeg";
	private static String UNIDADDEPORTIVA = "imagenes\\unidaddeportivapanamericana.png";
	private static String ZOOLOGICODECALI = "imagenes\\zoologicodecali.jpg";
	private static String PLATILLOSVOLADORES = "imagenes\\platillosvoladores.jpg";
	ArrayList<Circle> circles;
	ArrayList<Line> lines;

	public economictravelGUI() {

		tg = new TravelGuide();
		start = new Label();
		end = new Label();
	}

	public void loadMainMenu() throws IOException, EmptyQueueException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Map.fxml"));
		fxmlLoader.setController(this);
		Parent mape = fxmlLoader.load();
		tg.importData(tg.getSavePathFile());
		tg.initialize();
		basePane.setCenter(mape);
		zoom(map);
		addCirclesToList();
		initializePlacesTable();
		initializesearchOptionComboBox();
		initializerestrictionComboBox();
		initializeSomeLabels();
		tg.getCali().floydWarshallEdges();
		fromplacelabel.setTextFill(Color.BLUE);
		restrictionComboBox.setVisible(false);
		restrictionOptionLabel.setVisible(false);
		File a = new File("imagenes\\CaliHD.png");
		Image im = new Image(a.toURI().toString());
		caliMap.setImage(im);

	}

	public void addCirclesToList() {
		lines = new ArrayList<>();
		circles = new ArrayList<>();
		circles.add(acuaparquedelacañaV);
		circles.add(elplanetarioV);
		circles.add(bibliotecaJoseGarcesV);
		circles.add(museocienciasnaturalesV);
		circles.add(bulevardelrioV);
		circles.add(camV);
		circles.add(catedralsanpedroV);
		circles.add(iglesiaSanfranciscoV);
		circles.add(centroculturadecaliV);
		circles.add(cristoReyV);
		circles.add(zoologicodecaliV);
		circles.add(elgatodelrioV);
		circles.add(museodelatertuliaV);
		circles.add(monumentoAlDeporteV);
		circles.add(unidaddeportivaV);
		circles.add(pascualGuerreroV);
		circles.add(plazadetoroscañaveralejoV);
		circles.add(gobernaciondelValleV);
		circles.add(teatromunicipalV);
		circles.add(hospitaluniversitarioV);
		circles.add(hoteltorredecaliV);
		circles.add(iglesialaermitaV);
		circles.add(parquedelospoetasV);
		circles.add(iglesiaSanAntonioV);
		circles.add(sebastiandebelalczararV);
		circles.add(lomadelacruzV);
		circles.add(miradortrescrucesV);
		circles.add(monumentoamariamulataV);
		circles.add(monumentoALaAviacionV);
		circles.add(monumentoalasolidaridadempresarialV);
		circles.add(museolamercedV);
		circles.add(museodelorocalimaV);
		circles.add(parquedelasaludV);
		circles.add(jardinPlazaV);
		circles.add(plazaCaycedoV);
		circles.add(jairoVarelaV);
		circles.add(elbochincheV);
		circles.add(hotelintercontinentalV);
		circles.add(hoteldanncarlton);
		circles.add(platillosVoladoresV);
		circles.add(chipichapeV);
		circles.add(unicentroV);	
	}

	public ArrayList<Vertex> getArrayListOfVertexOfRoute(String nv1, String nv2, int type) throws EmptyQueueException {


		ArrayList<Vertex> route = new ArrayList<>();
		Vector<String> routeBefore = new Vector<>();
		int i1 = 0;
		int i2 = 0;

		if(!nv1.equalsIgnoreCase("") && !nv2.equalsIgnoreCase("")) {
			i1 = tg.getCali().searchVertex(nv1).getIndicator();
			i2 = tg.getCali().searchVertex(nv2).getIndicator();
		}
		switch(type) {

		case 0:
			routeBefore = tg.getCali().constructPathTime(i1,i2);

			for(int i = 0; i< tg.getCali().constructPathTime(i1, i2).size(); i++) {

				Vertex c = tg.getCali().searchVertex(routeBefore.get(i));
				route.add(c);
			}
			break;

		case 1:
			routeBefore = tg.getCali().constructPathCost(i1,i2);

			for(int i = 0; i< tg.getCali().constructPathCost(i1, i2).size(); i++) {

				Vertex c = tg.getCali().searchVertex(routeBefore.get(i));
				route.add(c);
			}
			break;
		case 2:
			for (Integer key : tg.getCali().getEdges().keySet()) {
				Edge e = tg.getCali().getEdges().get(key);
				if (e.isUseThisWay()) {

					route.add(e.getV1());
					route.add(e.getV2());
				}
			}
			break;
		default:
			break;
		}

		return route;
	}

	public String constructPathPrim(ArrayList<Vertex> routes) {

		String info = "Route: ";

		for(int i = 0; i <routes.size(); i++) {


			info+= routes.get(i).getName()+ " - ";
		}

		return info;
	}

	public void  putLinesToShowRoute(ArrayList<Vertex> vertex, Color color) {

		for(int i = 0 ; i< vertex.size()-1; i++) {


			Line l = new Line();
			l.setStartX(circles.get(vertex.get(i).getIndicator()).getLayoutX());
			l.setStartY(circles.get(vertex.get(i).getIndicator()).getLayoutY());
			l.setEndX(circles.get(vertex.get(i+1).getIndicator()).getLayoutX());
			l.setEndY(circles.get(vertex.get(i+1).getIndicator()).getLayoutY());
			l.setStrokeType(StrokeType.OUTSIDE);
			l.setFill(Color.BLACK);
			l.setStroke(color);
			l.setStrokeWidth(2);
			map.getChildren().add(l);
			lines.add(l);
		}

		start.setTextFill(Color.RED);
		end.setTextFill(Color.RED);
		start.setText("Start");
		start.setLayoutX(lines.get(0).getStartX());
		start.setLayoutY(lines.get(0).getStartY());
		end.setText("End");
		end.setLayoutX(lines.get(lines.size()-1).getEndX());
		end.setLayoutY(lines.get(lines.size()-1).getEndY());
		map.getChildren().add(start);
		map.getChildren().add(end);

	}

	public void move(AnchorPane m) {
	}

	public void zoom( AnchorPane pane) {
		pane.setOnScroll(
				new EventHandler<ScrollEvent>() {
					@Override
					public void handle(ScrollEvent event) {
						double zoomFactor = 1.05;
						double deltaY = event.getDeltaY();

						if (deltaY < 0){
							zoomFactor = 0.95;
						}
						pane.setScaleX(pane.getScaleX() * zoomFactor);
						pane.setScaleY(pane.getScaleY() * zoomFactor);
						event.consume();

					}

				});
	}
	@FXML
	void catedralsanpedro(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(CATEDRALMETROPOLITANA);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #5");
		alert.setContentText("Usted seleccionó la catedral metropolitana de San Pedro");
		alert.showAndWait();

	}
	@FXML
	void clickOnAcuaparquedelaCaña(MouseEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(ACUAPARQUE);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #1");
		alert.setContentText("Usted seleccionó acuaparque de la caña");
		alert.showAndWait();
	}
	@FXML
	void clickOnBibliotecaJoseGarces(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(BIBLIOTECAJORGEGARCES);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #2");
		alert.setContentText("Usted seleccionó la biblioteca departamental Jorge Garces Borrero");
		alert.showAndWait();
	}
	@FXML
	void clickOnBulevarDelRio(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(BULEVARDELRIO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #3");
		alert.setContentText("Usted seleccionó el bulevar del Rio");
		alert.showAndWait();

	}
	@FXML
	void clickOnCam(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(CAM);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #4");
		alert.setContentText("Usted seleccionó el CAM");
		alert.showAndWait();


	}
	@FXML
	void clickOnCentroculturaldecali(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(CENTROCULTURALCALI);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #6");
		alert.setContentText("Usted seleccionó el centro cultural de Cali");
		alert.showAndWait();
	}
	@FXML
	void clickOnChipichape(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(CHIPICHAPE);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #40");
		alert.setContentText("Usted seleccionó el Centro Comercial Chipichape");
		alert.showAndWait();


	}
	@FXML
	void clickOnCristoRey(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(CRISTOREY);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #7");
		alert.setContentText("Usted seleccionó Cristo Rey");
		alert.showAndWait();

	}
	@FXML
	void clickOnElBochinche(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(ELBOCHINCHE);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #36");
		alert.setContentText("Usted seleccionó el restaurante El Bochinche");
		alert.showAndWait();

	}
	@FXML
	void clickOnElGatodelRio(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(ELGATODELRIO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #8");
		alert.setContentText("Usted seleccionó El Gato del Rio");
		alert.showAndWait();

	}
	@FXML
	void clickOnElPlanetario(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(ELPLANETARIO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #9");
		alert.setContentText("Usted seleccionó El Planetario");
		alert.showAndWait();

	}
	@FXML
	void clickOnGobernaciondelValle(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(GOBERNACIONDELVALLE);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #12");
		alert.setContentText("Usted seleccionó La Gobernación del Valle");
		alert.showAndWait();

	}
	@FXML
	void clickOnHospitalUniversitario(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(HOSPITALUNIVERSITARIO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #13");
		alert.setContentText("Usted seleccionó El Hospital Universitario del Valle");
		alert.showAndWait();

	}
	@FXML
	void clickOnHotelIntercontinental(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(HOTELINTERCONTINENTAL);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #37");
		alert.setContentText("Usted seleccionó El Hotel Intercontinental");
		alert.showAndWait();

	}
	@FXML
	void clickOnHotelTorredeCali(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(HOTELTORREDECALI);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #14");
		alert.setContentText("Usted seleccionó El Hotel Torre de Cali");
		alert.showAndWait();

	}
	@FXML
	void clickOnIglesiaLaErmita(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(LAERMITA);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #15");
		alert.setContentText("Usted seleccionó La Iglesia La Ermita");
		alert.showAndWait();


	}
	@FXML
	void clickOnJairoVarela(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(JAIROVARELA);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #32");
		alert.setContentText("Usted seleccionó La Plazoleta Jairo Varela");
		alert.showAndWait();

	}

	@FXML
	void clickOnJardinPlaza(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(JARDINPLAZA);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #42");
		alert.setContentText("Usted seleccionó el Centro Comercial Jardin Plaza");
		alert.showAndWait();

	}
	@FXML
	void clickOnLomaDeLaCruz(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(LOMADELACRUZ);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #18");
		alert.setContentText("Usted seleccionó La Loma de la Cruz");
		alert.showAndWait();

	}
	@FXML
	void clickOnMariaMulata(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MONUMENTOALAMARIA);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #22");
		alert.setContentText("Usted seleccionó El Monumento a Maria Mulata");
		alert.showAndWait();

	}
	@FXML
	void clickOnMiradorTresCruces(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MIRADORTRESCRUCES);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #19");
		alert.setContentText("Usted seleccionó El Mirador Tres Cruces");
		alert.showAndWait();

	}
	@FXML
	void clickOnMonumentoALaAviacion(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MONUMENTOALAVIACION);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #20");
		alert.setContentText("Usted seleccionó El Monumento a la Aviación");
		alert.showAndWait();

	}
	@FXML
	void clickOnMonumentoALaSolidaridadEmpresarial(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MONUMENTOALASOLIDARIDAD);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #21");
		alert.setContentText("Usted seleccionó El Monumento a la Solidaridad Empresarial");
		alert.showAndWait();
	}
	@FXML
	void clickOnMonumentoAlDeporte(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MONUMENTOALDEPORTE);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #23");
		alert.setContentText("Usted seleccionó el Monumento al Deporte");
		alert.showAndWait();

	}

	@FXML
	void clickOnMuseoCienciasNaturales(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MUSEODEPARTAMENTALCIENCIA);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #27");
		alert.setContentText("Usted seleccionó El Museo Departamental de Ciencias Naturales");
		alert.showAndWait();
	}
	@FXML
	void clickOnMuseoDelOroCalima(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MUSEODELORO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #26");
		alert.setContentText("Usted seleccionó El Museo del oro Camila");
		alert.showAndWait();

	}
	@FXML
	void clickOnMuseoLaMerced(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MUSEOARQUEOLOGICO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #24");
		alert.setContentText("Usted seleccionó El Museo Arqueologico La Merced");
		alert.showAndWait();


	}
	@FXML
	void clickOnParquedelasalud(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(PARQUEDELASALUD);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #28");
		alert.setContentText("Usted seleccionó El Parque de la Salud");
		alert.showAndWait();

	}
	@FXML
	void clickOnParquedelospoetas(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(PARQUEDELOSPOETAS);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #29");
		alert.setContentText("Usted seleccionó El Parque de los Poetas");
		alert.showAndWait();

	}
	@FXML
	void clickOnPascualGuerrero(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(PASCUALGUERRERO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #11");
		alert.setContentText("Usted seleccionó El Estadio Olimpico Pascual Guerrero");
		alert.showAndWait();

	}
	@FXML
	void clickOnPlatillosVoladores(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(PLATILLOSVOLADORES);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #39");
		alert.setContentText("Usted seleccionó El Restaurante Platillos Voladores");
		alert.showAndWait();

	}
	@FXML
	void clickOnPlazaCaycedo(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(PLAZACAICEDO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #30");
		alert.setContentText("Usted seleccionó La Plaza Caicedo");
		alert.showAndWait();
	}
	@FXML
	void clickOnPlazadeToros(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(PLAZADETOROS);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #31");
		alert.setContentText("Usted seleccionó La Plaza de Toros Cañaveralejo");
		alert.showAndWait();

	}
	@FXML
	void clickOnSanAntonio(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(IGLESIASANANTONIO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #16");
		alert.setContentText("Usted seleccionó La Iglesia San Antonio");
		alert.showAndWait();

	}
	@FXML
	void clickOnSanFrancisco(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(IGLESIASANFRANCISCO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #17");
		alert.setContentText("Usted seleccionó La Iglesia San Francisco");
		alert.showAndWait();

	}
	@FXML
	void clickOnSebastiandebelalcazaar(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MONUMENTOASEBASTIAN);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #33");
		alert.setContentText("Usted seleccionó El Monumento de Sebastian de Belalcazar");
		alert.showAndWait();

	}
	@FXML
	void clickOnTeatroMunicipal(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(TEATROMUNICIPAL);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #34");
		alert.setContentText("Usted seleccionó El Teatro Municipal");
		alert.showAndWait();

	}
	@FXML
	void clickOnUnicentro(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(UNICENTRO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #41");
		alert.setContentText("Usted seleccionó El Centro Comercial Unicentro");
		alert.showAndWait();

	}
	@FXML
	void clickOnUnidadDeportiva(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(UNIDADDEPORTIVA);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #10");
		alert.setContentText("Usted seleccionó La Unidad Deportiva Panamericana");
		alert.showAndWait();

	}
	@FXML
	void clickOnZoologicodeCali(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(ZOOLOGICODECALI);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #35");
		alert.setContentText("Usted seleccionó El Zoologico de Cali");
		alert.showAndWait();

	}
	@FXML
	void clickOnhotelDarnnCarlton(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(HOTELDARNNCARLTON);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #38");
		alert.setContentText("Usted seleccionó El Hotel Darrn Carlton");
		alert.showAndWait();

	}
	@FXML
	void clickOnmuseodelatertulia(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MUSEOTERTULIA);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #25");
		alert.setContentText("Usted seleccionó El Museo de Arte Moderno La Tertulia");
		alert.showAndWait();

	}
	public void initializeSomeLabels() {
		youcanlabel.setVisible(false);
		youcantlabel.setVisible(false);
		limittxt.setVisible(false);
		limitlabel.setVisible(false);

	}
	public void initializePlacesTable() {

		ObservableList <Vertex> oblist;
		oblist = FXCollections.observableList(tg.toArrayFromHash());
		PlacesTable.setItems(oblist);
		Fr.setCellValueFactory(new PropertyValueFactory<Vertex,String>("name"));

	}
	public void initializesearchOptionComboBox() {

		ArrayList<String> op = new ArrayList<>();
		op.add("To Quote Trip");
		op.add("To Quote Trip with Limit");
		op.add("Tour of all the places in the city");
		ObservableList<String> options = FXCollections.observableList(op);
		searchOptionComboBox.setItems(options);
	}
	public void initializerestrictionComboBox() {

		ArrayList<String> op = new ArrayList<>();
		op.add("Time");
		op.add("Cost");
		ObservableList<String> options = FXCollections.observableList(op);
		restrictionComboBox.setItems(options);

	}
	@FXML
	void searchOption(ActionEvent event) {
		if(searchOptionComboBox.getSelectionModel().getSelectedItem() != null) {
			if(searchOptionComboBox.getSelectionModel().getSelectedIndex() == 1) {
				youcanlabel.setVisible(true);
				youcantlabel.setVisible(true);
				limitlabel.setVisible(true);
				limittxt.setVisible(true);
			}else {
				youcanlabel.setVisible(false);
				youcantlabel.setVisible(false);
				limitlabel.setVisible(false);
				limittxt.setVisible(false);
				youcanlabel.setTextFill(Color.BLACK);
				youcantlabel.setTextFill(Color.BLACK);
				youcantlabel.setText("You cant go with that limit");
			}

			restrictionComboBox.setVisible(true);
			restrictionOptionLabel.setVisible(true);	
		}
	}

	@FXML
	void restrictionOption(ActionEvent event) {

		if(searchOptionComboBox.getSelectionModel().getSelectedItem() != null) {
			if(searchOptionComboBox.getSelectionModel().getSelectedIndex() == 1) {	
				if(restrictionComboBox.getSelectionModel().getSelectedIndex() == 0) {				
					limitlabel.setText("Time limit");
				}else if(searchOptionComboBox.getSelectionModel().getSelectedIndex() == 1) {		
					limitlabel.setText("Cost limit");
				}
			}
		}		
	}

	@FXML
	void showRoute(ActionEvent event) {

		youcantlabel.setText("You cant go with that limit");
		Color color = routecolor.getValue();
		tg.getCali().resetEdgesMark();
		map.getChildren().remove(start);
		map.getChildren().remove(end);
		ObservableList<Line> lines2 = FXCollections.observableList(lines);
		map.getChildren().removeAll(lines2);
		lines.clear();
		int limit = 0;
		String info = "";
		String v1 = fromplacelabel.getText();
		String v2 = toplacelabel.getText();
		ArrayList<Vertex> route = new ArrayList<>();
		boolean youcango = false;
		int time = 0;
		if(searchOptionComboBox.getSelectionModel().getSelectedItem() != null) {
			switch(searchOptionComboBox.getSelectionModel().getSelectedIndex()) {
			case 0:
				switch(restrictionComboBox.getSelectionModel().getSelectedIndex()){
				case 0:
					try {
						putLinesToShowRoute(getArrayListOfVertexOfRoute(v1,v2,0),color);
						info = tg.searchPathByNamesTimes(v1,v2);
						time = tg.getCali().minimumTime(v1, v2);

					} catch (NumberFormatException | EmptyQueueException e) {
						showAlertWhenInvalidInput();
						e.printStackTrace();	
					}	
					showAlertWithRoute(v1,v2,info,time, false);
					break;
				case 1:
					try {
						putLinesToShowRoute(getArrayListOfVertexOfRoute(v1,v2,1),color);
						info = tg.searchPathByNamesCost(v1,v2);
						time = tg.getCali().priceToPay(v1, v2);

					} catch (NumberFormatException | EmptyQueueException e) {
						showAlertWhenInvalidInput();
						e.printStackTrace();	
					}		
					showAlertWithRoute(v1,v2,info,time, true);
					break;
				}
				break;
			case 1:
				limit = Integer.parseInt(limittxt.getText());
				switch(restrictionComboBox.getSelectionModel().getSelectedIndex()) {
				case 0:
					try {
						youcango = tg.getCali().travelWithTimeLimit(v1, v2, limit);
						time = tg.getCali().minimumTime(v1, v2);
						info = tg.searchPathByNamesTimes(v1,v2);
						if(youcango == false) {

							youcanlabel.setTextFill(Color.RED);
							youcantlabel.setTextFill(Color.GREEN);
							youcantlabel.setText("you need " +(time-limit)+" more minutes");
							limittxt.clear();
						}else {

							youcanlabel.setTextFill(Color.GREEN);
							youcantlabel.setTextFill(Color.RED);
							putLinesToShowRoute(getArrayListOfVertexOfRoute(v1,v2,0),color);
							showAlertWithRoute(v1,v2,info,time, false);
							limittxt.clear();
						}
					} catch (NumberFormatException | EmptyQueueException e) {

						showAlertWhenInvalidInput();
						e.printStackTrace();	
					}

					break;

				case 1:
					try {
						youcango = tg.getCali().priceToPayWithLimit(v1, v2, limit);
						time = tg.getCali().priceToPay(v1, v2);
						info = tg.searchPathByNamesCost(v1,v2);
						if(youcango == false) {

							youcanlabel.setTextFill(Color.RED);
							youcantlabel.setTextFill(Color.GREEN);
							youcantlabel.setText("you need " +(time-limit)+"more");
							limittxt.clear();
						}else {

							youcanlabel.setTextFill(Color.GREEN);
							youcantlabel.setTextFill(Color.RED);
							putLinesToShowRoute(getArrayListOfVertexOfRoute(v1,v2,1),color);
							showAlertWithRoute(v1,v2,info,time, true);
							limittxt.clear();
						}
					} catch (NumberFormatException | EmptyQueueException e) {

						showAlertWhenInvalidInput();
						e.printStackTrace();	
					}

					break;
				}
				break;
			case 2:
				switch(restrictionComboBox.getSelectionModel().getSelectedIndex()) {
				case 0:				
					try {
						tg.getCali().primForTime();	
						route = getArrayListOfVertexOfRoute("","",2);
						putLinesToShowRoute(route,color);
						info = constructPathPrim(route);
						showAlertWithRoute("","",info,time,false);

					} catch (EmptyQueueException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					break;

				case 1:
					try {
						tg.getCali().primForCost();	
						route = getArrayListOfVertexOfRoute("","",2);
						putLinesToShowRoute(route,color);
						info = constructPathPrim(route);
						showAlertWithRoute("","",info,time,true);

					} catch (EmptyQueueException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				break;

			default:
				break;
			}

		}
	}
	@FXML
	void switchPlace(ActionEvent event) {

		if(fromplacelabel.getTextFill() == Color.BLUE) {

			toplacelabel.setTextFill(Color.BLUE);
			fromplacelabel.setTextFill(Color.BLACK);

		}else {	
			fromplacelabel.setTextFill(Color.BLUE);
			toplacelabel.setTextFill(Color.BLACK);

		}

	}
	@FXML
	void clickOnPlace(MouseEvent event) {

		if(toplacelabel.getTextFill() == Color.BLUE) {

			toplacelabel.setText(PlacesTable.getSelectionModel().getSelectedItem().getName());
		}else{

			fromplacelabel.setText(PlacesTable.getSelectionModel().getSelectedItem().getName());
		}

	}
	public void showAlertWithRoute(String v1, String v2, String info, int time, boolean cost) {


		Alert alert = new Alert(AlertType.INFORMATION);

		if(!v1.equalsIgnoreCase("") && !v2.equalsIgnoreCase("")) {	
			if(cost == true) {	
				alert.setHeaderText("Route Information: "+v1+" - "+v2+"\n"+"Minimum Cost: "+time);
			}else {			
				alert.setHeaderText("Route Information: "+v1+" - "+v2+"\n"+"Minimum Time: "+time+" minutes ");	
			}
		}else {
			if(cost == true) {	
				alert.setHeaderText("All Places route by cost"+"\n");

			}else {		
				alert.setHeaderText("All places route by time"+"\n");
			}		
		}
		alert.setContentText(info);
		alert.showAndWait();

	}
	public void showAlertWhenInvalidInput() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("ERROR");
		alert.setContentText("Your choose an invalid Option");
		alert.showAndWait();

	}

}
