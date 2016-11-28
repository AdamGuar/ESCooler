import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class FuzzySystem {

	public static void main(String[] args) {

		String fileName = "core.fcl";
        FIS fis = FIS.load(fileName,true);

        // Error while loading?
        if( fis == null ) { 
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }
        
        
        FunctionBlock functionBlock = fis.getFunctionBlock(null);
        
        // Show 
        JFuzzyChart.get().chart(functionBlock);

        // Set inputs
        fis.setVariable("cpu_temp", 50);
        fis.setVariable("gc_temp", 70);

        // Evaluate
        fis.evaluate();

        // Show output variable's chart
        Variable tip = functionBlock.getVariable("");
        JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);

        // Print ruleSet
        System.out.println(fis);
	}

}
