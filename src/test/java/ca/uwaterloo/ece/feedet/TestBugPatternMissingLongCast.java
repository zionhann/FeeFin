package ca.uwaterloo.ece.feedet;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.junit.Test;

import ca.uwaterloo.ece.feedet.DetectionRecord;
import ca.uwaterloo.ece.feedet.bugpatterns.MissingLongCast;
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
public class TestBugPatternMissingLongCast {
	
	HashSet<DetectionRecord> identifiedPotentialBug = new HashSet<DetectionRecord>();
	
    @Test public void testSomeLibraryMethod() {
    	
    	String projectPathRoot1 = System.getProperty("user.home") + "/Documents/githubProjects/apache"; //System.getProperty("user.home") + "/X"; // "/Volumes/Faith/githubProjects/apache"; //System.getProperty("user.home") + "/Documents/githubProjects/apache";

    	int numOfTPs = 0;
    	
    	// TP hbase-server/src/main/java/org/apache/hadoop/hbase/regionserver/compactions/Compactor.java	cb17c7a97a1e2eb0ebd532f614191e4edbb9e49b
    	// -    long shippedCallSizeLimit = minFilesToCompact * HConstants.DEFAULT_BLOCKSIZE;
    	// +    long shippedCallSizeLimit = (long) minFilesToCompact * HConstants.DEFAULT_BLOCKSIZE;
    	
    	String projectName = "hbase";
    	String gitURI = projectPathRoot1 + File.separator + projectName;
    	String path = "hbase-server/src/main/java/org/apache/hadoop/hbase/regionserver/compactions/Compactor.java";
    	String shaId = "cb17c7a97a1e2eb0ebd532f614191e4edbb9e49b~1";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(++numOfTPs,identifiedPotentialBug.size());
    	
    	// FP hadoop  Alive   2273a74c1f3895163046cca09ff5e983df301d22        hadoop-mapreduce-project/hadoop-mapreduce-client/hadoop-mapreduce-client-app/src/main/java/org/apache/hadoop/mapreduce/v2/app/rm/RMContainerAllocator.java
    	// 660     Math.ceil(reduceSlowStart * totalMaps)
    	projectName = "hadoop";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "hadoop-mapreduce-project/hadoop-mapreduce-client/hadoop-mapreduce-client-app/src/main/java/org/apache/hadoop/mapreduce/v2/app/rm/RMContainerAllocator.java";
    	shaId = "2273a74c1f3895163046cca09ff5e983df301d22";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(numOfTPs,identifiedPotentialBug.size());
    	
    	// TODO This is TP but difficult to implement just for now
//    	// TP hbase-server/src/main/java/org/apache/hadoop/hbase/snapshot/ExportSnapshot.java	cb17c7a97a1e2eb0ebd532f614191e4edbb9e49b
//    	// -        in = new ThrottledInputStream(new BufferedInputStream(in), bandwidthMB * 1024 * 1024);
//    	// +        in = new ThrottledInputStream(new BufferedInputStream(in), bandwidthMB * 1024 * 1024L);
//    	projectName = "hbase";
//    	gitURI = projectPathRoot1 + File.separator + projectName;
//    	path = "hbase-server/src/main/java/org/apache/hadoop/hbase/snapshot/ExportSnapshot.java";
//    	shaId = "cb17c7a97a1e2eb0ebd532f614191e4edbb9e49b~1";
// 
//    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
//    	assertEquals(++numOfTPs,identifiedPotentialBug.size());
    	
    	// TP hbase-server/src/main/java/org/apache/hadoop/hbase/regionserver/HRegionFileSystem.java	6e2df4c6172cc305d457177e3c9464ba7d83e2f0
    	// -    Threads.sleep(baseSleepBeforeRetries * sleepMultiplier);
    	// +    Threads.sleep((long)baseSleepBeforeRetries * sleepMultiplier);
    	projectName = "hbase";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "hbase-server/src/main/java/org/apache/hadoop/hbase/regionserver/HRegionFileSystem.java";
    	shaId = "6e2df4c6172cc305d457177e3c9464ba7d83e2f0~1";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(++numOfTPs,identifiedPotentialBug.size());
    	
    	// FP hbase-server/src/main/java/org/apache/hadoop/hbase/snapshot/ExportSnapshot.java	cb17c7a97a1e2eb0ebd532f614191e4edbb9e49b
    	// +        in = new ThrottledInputStream(new BufferedInputStream(in), bandwidthMB * 1024 * 1024L);
    	projectName = "hbase";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "hbase-server/src/main/java/org/apache/hadoop/hbase/snapshot/ExportSnapshot.java";
    	shaId = "cb17c7a97a1e2eb0ebd532f614191e4edbb9e49b";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(numOfTPs,identifiedPotentialBug.size());
    	
    	// FP MissingLongCast manifoldcf-integration-solr-3.x path_deleted    3ee0ace1ba6b9bff3ffaa278c0bba07e60064057d
    	// lucene/backwards/src/java/org/apache/lucene/util/RamUsageEstimator.java
    	// 174     ONE_GB=ONE_KKB * ONE_MB
    	projectName = "manifoldcf-integration-solr-3.x";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "lucene/src/java/org/apache/lucene/util/RamUsageEstimator.java";
    	shaId = "addd1bef5065d240ec653c971f1518e7102349c2";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(numOfTPs,identifiedPotentialBug.size());
    	
    	// FP cassandra       Alive   d596a47cf1d2aaa8d1b4e98f886e0042a62cb9af
    	// src/java/org/apache/cassandra/utils/CoalescingStrategies.java   102     
    	// sleep=messages * averageGap
    	projectName = "cassandra";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "src/java/org/apache/cassandra/utils/CoalescingStrategies.java";
    	shaId = "d596a47cf1d2aaa8d1b4e98f886e0042a62cb9af";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(numOfTPs,identifiedPotentialBug.size());
    	
    	// FP flink	1e6f8f342d2fa1cdcc92efbfb552c66e60c78a06	610082d9788b5544b29bab9176f48eea1a45d940
    	// pact/pact-compiler/src/main/java/eu/stratosphere/pact/compiler/plan/CrossNode.java	224	
    	// estNumStubCalls=pred1.estimatedNumRecords * pred2.estimatedNumRecords
    	// difficult to track type of operands
    	projectName = "flink";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "pact/pact-compiler/src/main/java/eu/stratosphere/pact/compiler/plan/CrossNode.java";
    	shaId = "610082d9788b5544b29bab9176f48eea1a45d940";
 
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
			
			process(prjName,new MissingLongCast(prjName,preFixWholeCodeAST,shaId,path,repo).detect());
			
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
