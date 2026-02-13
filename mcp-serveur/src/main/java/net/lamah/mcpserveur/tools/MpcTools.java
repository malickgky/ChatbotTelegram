package net.lamah.mcpserveur.tools;

import org.springaicommunity.mcp.annotation.McpArg;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

import java.util.List;

public class MpcTools {

    @McpTool(name = "getEmployee",
            description = "Get information about a given employee")

    public Employee getEmployee(@McpArg(description = "The employee  name") String name ){
        return new Employee(name,12000,4 );
    }
    @McpTool(description = "Get All Employee")
    public List<Employee> getAllEmployees(){
        return  List.of(
                new Employee("Lamah", 1299, 2),
                new Employee("Augustin", 2711, 4),
                new Employee("Roger",18000, 10)
        );
    }
}
record Employee(String name,double salary, int seniority){}