import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class calculadoraGUI implements ActionListener {
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	JButton button9;
	JButton button0;
	JButton buttonMais;
	JButton buttonMenos;
	JButton buttonVezes;
	JButton buttonDividir;
	JButton buttonIgual;

	JLabel label1 = new JLabel("", SwingConstants.CENTER);

	JPanel panelNumeros;
	JPanel panelExtras;
	JPanel panelOperadores;
	JPanel panelVisor;

	JFrame frame;

	String visorTexto = ("");
	String operadorUsado = ("");
	public String operadorErrado = ("");

	public int i = 0;
	public int valorReal1 = 0;
	public int valorReal2 = 0;
	public int posicaoNumero = 1;
	public int operacaoVazia = 0;
	public int index = 1;
	public int potencia = 1;
	public int resultado = 0;
	public int valorAposResultado = 0;

	DecimalFormat numberFormat = new DecimalFormat("#.####");

	public boolean antesOperador = true;

	public String firstNumber = "";
	public String operator = "";
	public String secondNumber = "";
	public boolean lastNumber = false;

	public ArrayList<Integer> primeiroNumero = new ArrayList<>();
	public ArrayList<Integer> segundoNumero = new ArrayList<>();

	public static void main(String[] args) {
		new calculadoraGUI();
	}

	public calculadoraGUI() {
		button1 = new JButton("|  1  |");
		button2 = new JButton("|  2  |");
		button3 = new JButton("|  3  |");
		button4 = new JButton("|  4  |");
		button5 = new JButton("|  5  |");
		button6 = new JButton("|  6  |");
		button7 = new JButton("|  7  |");
		button8 = new JButton("|  8  |");
		button9 = new JButton("|  9  |");
		button0 = new JButton("|  0  |");
		buttonMais = new JButton("+");
		buttonMenos = new JButton("-");
		buttonVezes = new JButton("*");
		buttonDividir = new JButton("/");
		buttonIgual = new JButton("=");

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		button0.addActionListener(this);
		buttonMais.addActionListener(this);
		buttonMenos.addActionListener(this);
		buttonVezes.addActionListener(this);
		buttonDividir.addActionListener(this);
		buttonIgual.addActionListener(this);

		button1.setPreferredSize(new Dimension(70, 70));
		button2.setPreferredSize(new Dimension(70, 70));
		button3.setPreferredSize(new Dimension(70, 70));
		button4.setPreferredSize(new Dimension(70, 70));
		button5.setPreferredSize(new Dimension(70, 70));
		button6.setPreferredSize(new Dimension(70, 70));
		button7.setPreferredSize(new Dimension(70, 70));
		button8.setPreferredSize(new Dimension(70, 70));
		button9.setPreferredSize(new Dimension(70, 70));
		button0.setPreferredSize(new Dimension(252, 50));
		buttonMais.setPreferredSize(new Dimension(42, 42));
		buttonMenos.setPreferredSize(new Dimension(42, 42));
		buttonVezes.setPreferredSize(new Dimension(42, 42));
		buttonDividir.setPreferredSize(new Dimension(42, 42));
		buttonIgual.setPreferredSize(new Dimension(42, 42));

		Font fonteAtualButton = button1.getFont();
		Font fonteNova = (fonteAtualButton.deriveFont(13f));

		button1.setFont(fonteNova);
		button2.setFont(fonteNova);
		button3.setFont(fonteNova);
		button4.setFont(fonteNova);
		button5.setFont(fonteNova);
		button6.setFont(fonteNova);
		button7.setFont(fonteNova);
		button8.setFont(fonteNova);
		button9.setFont(fonteNova);
		button0.setFont(fonteNova);
		buttonMais.setFont(fonteAtualButton.deriveFont(13f));
		buttonMenos.setFont(fonteNova);
		buttonVezes.setFont(fonteAtualButton.deriveFont(13f));
		buttonDividir.setFont(fonteNova);

		label1.setText(visorTexto);
		label1.setPreferredSize(new Dimension(252, 50));
		label1.setFont(fonteAtualButton.deriveFont(16f));

		numberFormat.setRoundingMode(RoundingMode.CEILING);

		panelNumeros = new JPanel();
		panelNumeros.setBorder(BorderFactory.createEmptyBorder(0, 205, 0, 0));
		panelNumeros.setLayout(new GridLayout(3, 3));

		panelExtras = new JPanel();
		panelExtras.setBorder(BorderFactory.createEmptyBorder(0, 205, 205, 205));
		panelExtras.setLayout(new GridLayout(1, 1));

		panelOperadores = new JPanel();
		panelOperadores.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 205));
		panelOperadores.setLayout(new GridLayout(5, 1));

		panelVisor = new JPanel();
		panelVisor.setBorder(BorderFactory.createEmptyBorder(205, 205, 0, 205));
		panelVisor.setLayout(new GridLayout(1, 1));

		panelNumeros.add(button1);
		panelNumeros.add(button2);
		panelNumeros.add(button3);
		panelNumeros.add(button4);
		panelNumeros.add(button5);
		panelNumeros.add(button6);
		panelNumeros.add(button7);
		panelNumeros.add(button8);
		panelNumeros.add(button9);

		panelExtras.add(button0);

		panelOperadores.add(buttonMais);
		panelOperadores.add(buttonMenos);
		panelOperadores.add(buttonVezes);
		panelOperadores.add(buttonDividir);
		panelOperadores.add(buttonIgual);

		panelVisor.add(label1);

		frame = new JFrame();
		frame.setSize(500, 500);
		frame.add(panelNumeros, BorderLayout.CENTER);
		frame.add(panelExtras, BorderLayout.SOUTH);
		frame.add(panelOperadores, BorderLayout.EAST);
		frame.add(panelVisor, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calculadora GUI");
		frame.pack();
		frame.setVisible(true);
	}

	@Override

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		String btnTxt = btn.getText();
		handleInput(btnTxt);
		drawEquation();
	}

	public void handleInput(String btnTxt) {
		if (isNumber(btnTxt)) {
			addNumber(btnTxt);
			return;
		}

		if (!lastNumber && !(btnTxt == "=")) {
			operator = btnTxt;
			lastNumber = true;
			return;
		}

		if (!(firstNumber == "") && !(secondNumber == "") && !(operator == "")) {
			float first = Float.parseFloat(firstNumber);
			float second = Float.parseFloat(secondNumber);
			float result = calculate(operator, first, second);
			resetNumbers(result);
		}
	}

	public void addNumber(String num) {
		if (lastNumber) {
			secondNumber += sanitize(num);
			System.out.println("second number " + secondNumber);
			return;
		}

		firstNumber += sanitize(num);
		System.out.println("first number " + firstNumber);
	}

	public void drawEquation() {
		label1.setText("" + firstNumber + operator + secondNumber);
	}

	public boolean isNumber(String value) {
		return value.contains("|");
	}

	public String sanitize(String value) {
		String cleanerValue = value.replace("|", "");
		return cleanerValue.replace(" ", "");
	}

	public void resetNumbers(float newFirstNumberValue) {
		firstNumber = String.valueOf(numberFormat.format(newFirstNumberValue));
		secondNumber = "";
		lastNumber = false;
		operator = "";
	}

	public float calculate(String operator, float first, float second) {
		switch (operator) {
			case "-":
				return first - second;
			case "+":
				return first + second;
			case "*":
				return first * second;
			case "/":
				return first / second;
			default:
				throw new IllegalArgumentException("vc eh burro");
		}
	}
}
