package ca.uwaterloo.ece.feedet;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.junit.Test;

import ca.uwaterloo.ece.feedet.DetectionRecord;
import ca.uwaterloo.ece.feedet.bugpatterns.WrongClassLogName;
import ca.uwaterloo.ece.feedet.utils.JavaASTParser;
import ca.uwaterloo.ece.feedet.utils.Utils;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/*
 * This Java source file was auto generated by running 'gradle init --type java-library'
 * by 'j22nam' at '27/05/16 5:45 PM' with Gradle 2.13
 *
 * @author j22nam, @date 27/05/16 5:45 PM
 */
public class TestBugPatternWrongClassLogName {
	
	HashSet<DetectionRecord> identifiedPotentialBug = new HashSet<DetectionRecord>();
	
    @Test public void testSomeLibraryMethod() {
    	
    	String projectPathRoot1 = System.getProperty("user.home") + "/Documents/githubProjects/apache"; //System.getProperty("user.home") + "/X"; // "/Volumes/Faith/githubProjects/apache"; //System.getProperty("user.home") + "/Documents/githubProjects/apache";

    	int numOfTPs = 0;
    	
    	// TP hbase-server/src/main/java/org/apache/hadoop/hbase/util/hbck/OfflineMetaRepair.java	2706742224ec0e89dee98a7b99e91d4c2853a63c
    	// -  private static final Log LOG = LogFactory.getLog(HBaseFsck.class.getName());
    	// +  private static final Log LOG = LogFactory.getLog(OfflineMetaRepair.class.getName());
    	String projectName = "hbase";
    	String gitURI = projectPathRoot1 + File.separator + projectName;
    	String path = "hbase-server/src/main/java/org/apache/hadoop/hbase/util/hbck/OfflineMetaRepair.java";
    	String shaId = "2706742224ec0e89dee98a7b99e91d4c2853a63c~1";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(++numOfTPs,identifiedPotentialBug.size());
    	
    	// FP hadoop	Alive	2273a74c1f3895163046cca09ff5e983df301d22
    	// hadoop-yarn-project/hadoop-yarn/hadoop-yarn-api/src/main/java/org/apache/hadoop/yarn/conf/YarnConfiguration.java
    	// 510	public static final long RM_DELEGATION_KEY_UPDATE_INTERVAL_DEFAULT=24 * 60 * 60* 1000;
    	/*projectName = "hadoop";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "hadoop-yarn-project/hadoop-yarn/hadoop-yarn-api/src/main/java/org/apache/hadoop/yarn/conf/YarnConfiguration.java";
    	shaId = "2273a74c1f3895163046cca09ff5e983df301d22";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(numOfTPs,identifiedPotentialBug.size());*/
    }

	private void detect(String prjName, String gitURI, String path, String shaId,HashSet<DetectionRecord> identifiedPotentialBug) {
		try {
    		Git git;
			git = Git.open( new File(gitURI) );
			Repository repo = git.getRepository();
			
			String fileSource=Utils.fetchBlob(repo, shaId, path);
			
			fileSource = Utils.removeComments(fileSource);
			
			JavaASTParser preFixWholeCodeAST = new JavaASTParser(fileSource);
			
			process(prjName,new WrongClassLogName(prjName,preFixWholeCodeAST,shaId,path,repo).detect());
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void process(String projectName,ArrayList<DetectionRecord> detectionRecords) {
		for(DetectionRecord detRec:detectionRecords){
			if(!identifiedPotentialBug.contains(detRec)){
				identifiedPotentialBug.add(detRec);
				System.out.println(detRec.getPatternName() + "\t" 
						+ projectName + "\t"
						+ detRec.getRevID() + "\t"
						+ detRec.getLineNum() + "\t"
						+ detRec.getPath());
				System.out.println(detRec.getCode() + "\n");
			}
		}
		
	}
}
