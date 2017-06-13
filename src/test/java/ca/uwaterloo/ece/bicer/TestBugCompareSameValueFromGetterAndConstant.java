package ca.uwaterloo.ece.bicer;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.junit.Test;

import ca.uwaterloo.ece.feedet.DetectionRecord;
import ca.uwaterloo.ece.feedet.bugpatterns.CompareSameValueFromGetterAndField;
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
public class TestBugCompareSameValueFromGetterAndConstant {
	
	HashSet<DetectionRecord> identifiedPotentialBug = new HashSet<DetectionRecord>();
	
    @Test public void testSomeLibraryMethod() {
    	
    	String projectPathRoot1 = System.getProperty("user.home") + "/Documents/githubProjects/apache"; //System.getProperty("user.home") + "/X"; // "/Volumes/Faith/githubProjects/apache"; //System.getProperty("user.home") + "/Documents/githubProjects/apache";
    	String projectPathRoot2 = System.getProperty("user.home") + "/Documents/githubProjects/google";
    	
    	int numOfTPs = 0;
    	
    	// TP src/main/java/org/apache/hadoop/hbase/HRegionInfo.java	0b0fa9708460883b0827691c6c50b4aaf2f81546
    	String projectName = "hbase";
    	String gitURI = projectPathRoot1 + File.separator + projectName;
    	String path = "src/main/java/org/apache/hadoop/hbase/HRegionInfo.java";
    	String shaId = "0b0fa9708460883b0827691c6c50b4aaf2f81546~1";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(++numOfTPs,identifiedPotentialBug.size());
    	
    	// FP	kafka 1abed91bd2915226cf6320395e1a5877ea0705d7	clients/src/main/java/org/apache/kafka/clients/consumer/internals/AbstractCoordinator.java	618	coordinator() == null
    	projectName = "kafka";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "clients/src/main/java/org/apache/kafka/clients/consumer/internals/AbstractCoordinator.java";
    	shaId = "1abed91bd2915226cf6320395e1a5877ea0705d7";
    	
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(numOfTPs,identifiedPotentialBug.size());
    	
    	// FP 73e382fa877f80994817a136b0adcc4365ccd904 guava/src/com/google/common/cache/LocalCache.java e.getHash() == hash
    	projectName = "guava";
    	gitURI = projectPathRoot2 + File.separator + projectName;
    	path = "guava/src/com/google/common/cache/LocalCache.java";
    	shaId = "73e382fa877f80994817a136b0adcc4365ccd904";
    	
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(numOfTPs,identifiedPotentialBug.size());
    	
    	// FP c462d69329709f72a17a64cb229d15e76e72199c        guava/src/com/google/common/io/MultiInputStream.java    117     read() == -1
    	projectName = "guava";
    	gitURI = projectPathRoot2 + File.separator + projectName;
    	path = "guava/src/com/google/common/io/MultiInputStream.java";
    	shaId = "c462d69329709f72a17a64cb229d15e76e72199c";
    	
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(numOfTPs,identifiedPotentialBug.size());
    	
    }

	private void detect(String prjName, String gitURI, String path, String shaId,HashSet<DetectionRecord> identifiedPotentialBug) {
		try {
    		Git git;
			git = Git.open( new File(gitURI) );
			Repository repo = git.getRepository();
			
			String fileSource=Utils.fetchBlob(repo, shaId, path);
			
			fileSource = Utils.removeComments(fileSource);
			
			JavaASTParser preFixWholeCodeAST = new JavaASTParser(fileSource);
			
			process(prjName,new CompareSameValueFromGetterAndField(prjName,preFixWholeCodeAST,shaId,path,repo).detect());
			
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
