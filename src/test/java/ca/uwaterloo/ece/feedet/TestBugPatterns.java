package ca.uwaterloo.ece.feedet;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.junit.Test;

import ca.uwaterloo.ece.feedet.DetectionRecord;
import ca.uwaterloo.ece.feedet.bugpatterns.EqualToSameExpression;
import ca.uwaterloo.ece.feedet.bugpatterns.IllogicalCondition;
import ca.uwaterloo.ece.feedet.bugpatterns.IllogicalConditionNPE;
import ca.uwaterloo.ece.feedet.bugpatterns.IncorrectDirectorySlash;
import ca.uwaterloo.ece.feedet.bugpatterns.IncorrectMapIterator;
import ca.uwaterloo.ece.feedet.bugpatterns.MissingThrow;
import ca.uwaterloo.ece.feedet.bugpatterns.RedundantCondition;
import ca.uwaterloo.ece.feedet.bugpatterns.RedundantException;
import ca.uwaterloo.ece.feedet.bugpatterns.RedundantInstantiation;
import ca.uwaterloo.ece.feedet.bugpatterns.SameObjEquals;
import ca.uwaterloo.ece.feedet.bugpatterns.WrongIncrementer;
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
public class TestBugPatterns {
	
	HashSet<DetectionRecord> identifiedPotentialBug = new HashSet<DetectionRecord>();
	
    @Test public void testSomeLibraryMethod() {
    	
    	String projectPathRoot1 = System.getProperty("user.home") + "/Documents/githubProjects/apache"; // "/Volumes/Faith/githubProjects/apache"; //System.getProperty("user.home") + "/Documents/githubProjects/apache";
    	String projectPathRoot2 = System.getProperty("user.home") + "/Documents/githubProjects/google";
    	String projectPathRoot3 = System.getProperty("user.home") + "/Documents/githubProjects/top200";
    	String projectPathRoot5 = System.getProperty("user.home") + "/Documents/githubProjects/top300";
    	String projectPathRoot4 = System.getProperty("user.home") + "/Documents/githubProjects/top400";
    	String projectPathRoot6 = System.getProperty("user.home") + "/Documents/githubProjects/top500";
    	String projectPathRoot7 = System.getProperty("user.home") + "/Documents/githubProjects/topSample";

    	
    	int numOfTPs = 0;
    	
    	String projectName = "jackrabbit";
    	String gitURI = projectPathRoot1 + File.separator + "jackrabbit";
    	String path = "jackrabbit-core/src/main/java/org/apache/jackrabbit/core/query/lucene/AggregateRuleImpl.java"; //	
    	String shaId = "ab29dc4a813b0fbb484daf486f540105d119b5f8~1";
        
    	// TP Illogical condition
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),++numOfTPs);
    	
    	// TP Illogical condition
    	path = "jackrabbit-core/src/main/java/org/apache/jackrabbit/core/persistence/bundle/util/ConnectionFactory.java"; //	
    	shaId = "6ed7f1a1ef3b9ae391a80c7c0477731f43b3021f~1";
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),++numOfTPs);
    	
    	// TP Redundant Instantiation
    	path = "jackrabbit-core/src/main/java/org/apache/jackrabbit/core/data/db/DbDataStore.java"; //	
    	shaId = "77df0827d1392b378c326d30739d6e68be65914d~1";
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),++numOfTPs);
    	
    	// TP IncorrectMapInterator
    	path = "jackrabbit-spi-commons/src/main/java/org/apache/jackrabbit/spi/commons/namespace/NamespaceAdder.java";
    	shaId = "b25f9f08df01a6334e51afd96f048aecacbb2ab6~1";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),++numOfTPs);
    	
    	// TP Missing throw 	
    	path = "jackrabbit-ocm/src/main/java/org/apache/jackrabbit/ocm/manager/collectionconverter/ManageableObjectsUtil.java";
    	shaId = "f51066e92851ce89358552035850f98d0d974265~1";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),++numOfTPs);
    	
    	// TP Missing time resolution
    	// jackrabbit-core/src/main/java/org/apache/jackrabbit/core/data/FileDataStore.java	7e69c1313a0077d33379a3c7c4d4039cca4c74a
    	/*path = "jackrabbit-core/src/main/java/org/apache/jackrabbit/core/data/FileDataStore.java";
    	shaId = "7e69c1313a0077d33379a3c7c4d4039cdca4c74a~1";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),++numOfTPs);*/
    	
    	// TP Wrong incrementor
    	// jackrabbit-core/src/main/java/org/apache/jackrabbit/core/nodetype/NodeTypeManagerImpl.java	e4ba7ecddd525b0127899f2e3c2ee09b6e02b430~1
    	path = "jackrabbit-core/src/main/java/org/apache/jackrabbit/core/nodetype/NodeTypeManagerImpl.java";
    	shaId = "e4ba7ecddd525b0127899f2e3c2ee09b6e02b430~1";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	numOfTPs+=3;
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// TP Same object equal
    	// jackrabbit-spi2dav/src/main/java/org/apache/jackrabbit/spi2davex/QValueFactoryImpl.java	13e8463a2b49ce08cb71c2ba64baf95358259b5e
    	path = "jackrabbit-spi2dav/src/main/java/org/apache/jackrabbit/spi2davex/QValueFactoryImpl.java";
    	shaId = "13e8463a2b49ce08cb71c2ba64baf95358259b5e~1";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),++numOfTPs);
    	
    	// FP groovy RedundantInstantiation:4c829ca397aae8f86c993c000d5ab8445c2a0189:src/main/org/codehaus/groovy/tools/javac/JavacJavaCompiler.java
    	gitURI = projectPathRoot1 + File.separator + "groovy";
    	path = "src/main/org/codehaus/groovy/tools/javac/JavacJavaCompiler.java"; //	
    	shaId = "4c829ca397aae8f86c993c000d5ab8445c2a0189";
    	projectName = "groovy";
    	
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs); //
    	
    	// FP IllogicalCondition
    	gitURI = projectPathRoot1 + File.separator + "tomee";
    	path = "server/openejb-cxf-rs/src/main/java/org/apache/openejb/server/cxf/rs/CxfRsHttpListener.java"; //	
    	shaId = "0b8ba18148ac86ec22ed352def3e570fe887b377";
    	projectName = "tomee";
    	
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP RedundantInstantiation
    	path = "container/openejb-core/src/main/java/org/apache/openejb/util/AnnotationFinder.java"; //	
    	shaId = "50228050e20b61705911aa22efd99997eb129504";
    	
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP RedundantInstantiation
    	// apex-core
    	// 3f06ce71cf88c790070d4067766ec5662ac0231f
    	// engine/src/main/java/com/datatorrent/stram/client/StramAppLauncher.java
    	gitURI = projectPathRoot1 + File.separator + "apex-core";
    	path = "engine/src/main/java/com/datatorrent/stram/client/StramAppLauncher.java"; //	
    	shaId = "3f06ce71cf88c790070d4067766ec5662ac0231f";
    	projectName = "apex-core";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs); //
    	
    	// TP IllogicalCondition 
    	// String opConsisLvl = (readOpConsLvl!=null || !readOpConsLvl.isEmpty())?readOpConsLvl:DEFAULT_HECTOR_CONSIS_LEVEL;
    	// opConsisLvl = (writeOpConsLvl!=null || !writeOpConsLvl.isEmpty())?writeOpConsLvl:DEFAULT_HECTOR_CONSIS_LEVEL;
    	// gora
    	//3796843b08037457fa31750121cb71c55387035e	gora-cassandra/src/main/java/org/apache/gora/cassandra/store/CassandraClient.java
    	gitURI = projectPathRoot1 + File.separator + "gora";
    	path = "gora-cassandra/src/main/java/org/apache/gora/cassandra/store/CassandraClient.java";
    	shaId = "3796843b08037457fa31750121cb71c55387035e";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs+=2);
    	projectName = "groovy";
    	
    	// false positive
    	// IllogicalCondition:ca650ef85c9945c5de022cc21ac3680e2b5696d5:maven/tomee-maven-plugin/src/main/java/org/apache/openejb/maven/plugin/UpdatableTomEEMojo.java
        //synchronization != null || synchronizations != null
    	gitURI = projectPathRoot1 + File.separator + "tomee";
    	path = "maven/tomee-maven-plugin/src/main/java/org/apache/openejb/maven/plugin/UpdatableTomEEMojo.java";
    	shaId = "ca650ef85c9945c5de022cc21ac3680e2b5696d5";
    	projectName = "tomee";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// False positive: RedundantException
    	// nifi-minifi
    	// 4cf2cea3e201b136fdf7fd83c453b4401d20cb99
    	// minifi-bootstrap/src/main/java/org/apache/nifi/minifi/bootstrap/RunMiNiFi.java
    	gitURI = projectPathRoot1 + File.separator + "nifi-minifi";
    	path = "minifi-bootstrap/src/main/java/org/apache/nifi/minifi/bootstrap/RunMiNiFi.java";
    	shaId = "4cf2cea3e201b136fdf7fd83c453b4401d20cb99";
    	projectName = "nifi-minifi";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// true positive RedundantException
    	//lucene/src/java/org/apache/lucene/store/Directory.java	a17aef52a4cfe81ed863dcb2fe1808013e9a2651	
    	gitURI = projectPathRoot1 + File.separator + "lucene-solr";
    	path = "lucene/src/java/org/apache/lucene/store/Directory.java";
    	shaId = "aff519123cce5c0659a466a2e8c87290d41bd096~1";
    	projectName = "lucene";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),++numOfTPs);
    	
    	// to check if the same detection result can be ignored
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP 
    	// IncorrectMapIterator:619e1f2293f742cefb34bcb280c1c98602d0cf62:/Volumes/Faith/githubProjects/apache/ode/utils/src/main/java/org/apache/ode/utils/HierarchicalProperties.java
    	/* for (Iterator it=hierarchicalMap.values().iterator(); it.hasNext(); ) {
    		  Map properties=((ChainedMap)it.next()).child;
    		  for (Iterator it1=properties.entrySet().iterator(); it1.hasNext(); ) {
    		    Map.Entry e=(Map.Entry)it1.next();
    		    e.setValue(SystemUtils.replaceProperties((String)e.getValue(),localPlaceholder,getRootMap().child));
    		    e.setValue(SystemUtils.replaceProperties((String)e.getValue(),systemProperty,System.getProperties()));
    		    e.setValue(SystemUtils.replaceProperties((String)e.getValue(),environmentVariable,System.getenv()));
    		  }
    		}
    	*/
    	gitURI = projectPathRoot1 + File.separator + "ode";
    	path = "utils/src/main/java/org/apache/ode/utils/HierarchicalProperties.java";
    	shaId = "619e1f2293f742cefb34bcb280c1c98602d0cf62";
    	projectName = "ode";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP
    	/*
    	 * MissingThrow:HEAD:/Volumes/Faith/githubProjects/apache/camel/components/camel-aws/src/main/java/org/apache/camel/component/aws/swf/CamelWorkflowDefinition.java
	    new TryCatchFinally(){
	      @Override protected void doTry() throws Throwable {
	        Object[] parameters=dataConverter.fromData(input,Object[].class);
	        long startTime=workflowClock.currentTimeMillis();
	        boolean replaying=contextProvider.getDecisionContext().getWorkflowClock().isReplaying();
	        LOGGER.debug("Processing workflow execute");
	        Object r=swfWorkflowConsumer.processWorkflow(parameters,startTime,replaying);
	        if (r instanceof Promise) {
	          methodResult.set((Promise<?>)r);
	        }
	     else     if (r != null) {
	          methodResult.set(new Settable<Object>(r));
	        }
	      }
	      @Override protected void doCatch(  Throwable e) throws Throwable {
	        if (!(e instanceof CancellationException) || !decisionContext.getWorkflowContext().isCancelRequested()) {
	          throwWorkflowException(dataConverter,e);
	        }
	      }
    	*/
    	gitURI = projectPathRoot1 + File.separator + "camel";
    	path = "components/camel-aws/src/main/java/org/apache/camel/component/aws/swf/CamelWorkflowDefinition.java";
    	shaId = "ea025880e07ec960a86a4ee5dbdfe60119e8087a";
    	projectName = "camel";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
        // TP
        // IncorrectDirectorySlash
        // 6b9c787a9bc1431fe0074255ab7fb168eb130650
        // modules/benchmark/src/java/org/apache/lucene/benchmark/utils/ExtractReuters.java
        gitURI = projectPathRoot1 + File.separator + "lucene-solr";
    	path = "modules/benchmark/src/java/org/apache/lucene/benchmark/utils/ExtractReuters.java";
    	shaId = "6b9c787a9bc1431fe0074255ab7fb168eb130650";
    	projectName = "lucene-solr";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),++numOfTPs);
    	
    	// FP
    	// Drill
    	// IncorrectDirectorySlash
    	//2f4b5ef717ed78a1ebb65687af9688a902e02041:common/src/main/java/org/apache/drill/version/Generator.java
        //File srcFile = new File(args[0] + "/org/apache/drill/common/util/DrillVersionInfo.java");
    	gitURI = projectPathRoot1 + File.separator + "drill";
    	path = "common/src/main/java/org/apache/drill/version/Generator.java";
    	shaId = "2f4b5ef717ed78a1ebb65687af9688a902e02041";
    	projectName = "drill";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	
    	// TP IllogicalCondition
    	// modules/core/src/org/apache/axis2/engine/AddressingBasedDispatcher.java
    	// 0701dfe5817af62a21d89ec588224572ff139fc9
    	// if ((relatesTo != null) || "".equals(relatesTo)) // ParenthesizedExpression
    	projectName = "axis2-java";
    	gitURI = projectPathRoot1 + File.separator + "axis2-java";
    	path = "modules/core/src/org/apache/axis2/engine/AddressingBasedDispatcher.java";
    	shaId = "0701dfe5817af62a21d89ec588224572ff139fc9";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),++numOfTPs);
    	
    	// FP Wrong incrementer
    	// modules/core/src/org/apache/axis2/engine/AddressingBasedDispatcher.java
    	// 0701dfe5817af62a21d89ec588224572ff139fc9
    	// if ((relatesTo != null) || "".equals(relatesTo)) // ParenthesizedExpression
    	projectName = "calcite";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "core/src/main/java/org/apache/calcite/rel/rules/CalcRelSplitter.java";
    	shaId = "6f761d367feb1819664f145b9f7732bff5e9c602";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	/* FP Wrong incrementer
    	 * example/function/src/main/java/org/apache/calcite/example/maze/Maze.java
    	 * 972b5de52dcacfa5d04d8af57716d23144dd93cc
    	 *  for (int z = 0; z < 5; z++) {
        		for (int i = 2; i < ints.length; i++) {
			          int x = ints[i] / 2 % width;
			          int y = ints[i] / 2 / width;
			          int xMin = Math.min(x, width - x);
			          int yMin = Math.min(y, height - y);
			          if (ints[i] % 2 == (xMin < yMin ? 1 : 0)) {
			            int j = random.nextInt(i);
			            int t = ints[j];
			            ints[j] = ints[i];
			            ints[i] = t;
			          }
			        }
    	 */
    	path = "example/function/src/main/java/org/apache/calcite/example/maze/Maze.java";
    	shaId = "6f761d367feb1819664f145b9f7732bff5e9c602";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP Wrong incrementer (should ignore when outer and inner targets are same)
    	// src/main/java/org/apache/commons/math4/dfp/Dfp.java
    	// 657b1b49da5ea1593dd7f950eae99a88a8ada87a
    	/*
    	 * for (int i = 0; i < mant.length; i++) {
            int rh = 0;  // acts as a carry
            for (int j=0; j<mant.length; j++) {
                int r = mant[i] * x.mant[j];    // multiply the 2 digits
                r += product[i+j] + rh;  // add to the product digit with carry in

                rh = r / RADIX;
                product[i+j] = r - rh * RADIX;
            }
            product[i+mant.length] = rh;
        }
    	 */
    	projectName = "commons-math";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "src/main/java/org/apache/commons/math4/dfp/Dfp.java";
    	shaId = "657b1b49da5ea1593dd7f950eae99a88a8ada87a";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// TP Wrong incrementer (should ignore when outer and inner targets are same)
    	projectName = "windowtester";
    	gitURI = projectPathRoot2 + File.separator + projectName;
    	path = "com.windowtester.swt.runtime/src/com/windowtester/runtime/swt/internal/finder/eclipse/views/ViewExplorer.java";
    	shaId = "c4febd2b11eff011ffe1cecc165c22661fa5b62e";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),++numOfTPs);
    	
    	// FP Wrong incrementer
    	projectName = "xerces2-j";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "src/org/apache/xerces/impl/v2/XSWildcardDecl.java";
    	shaId = "827eb8f272483a5a006fdd04558224bd267ccd5e";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP Wrong incrementer
    	projectName = "flink";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "pact/pact-compiler/src/main/java/eu/stratosphere/pact/compiler/plan/CoGroupNode.java";
    	shaId = "a8d6c35fff603917971b3ae3a9f76b4ca5130f3a";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP Wrong incrementer
    	projectName = "ferret";
    	gitURI = projectPathRoot2 + File.separator + projectName;
    	path = "logger/app/src/main/java/com/google/research/ic/alogger/EventRecord.java";
    	shaId = "85a8a1a975341bfdfeef76ee2fbea290818bcec5";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP Wrong incrementer
    	projectName = "sagetv";
    	gitURI = projectPathRoot2 + File.separator + projectName;
    	path = "java/sage/Seeker.java";
    	shaId = "544b48c161a330cf92ecb78bcca71a165322028e";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// TP Wrong incrementer
    	path = "java/sage/PseudoMenu.java";
    	shaId = "544b48c161a330cf92ecb78bcca71a165322028e";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),++numOfTPs);
    	
    	// FP Wrong incrementer
    	projectName = "cordova-android";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "framework/src/org/apache/cordova/ContactAccessorSdk5.java";
    	shaId = "0ad9ff0d873cd1e65052336939a144c4777bf9c0";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// TP Wrong incrementer
    	projectName = "incubator-joshua";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "src/main/java/org/apache/joshua/decoder/ff/lm/LanguageModelFF.java";
    	shaId = "f92b1ee246c51c02e2ca0a4de86ca8092306ed6c";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),++numOfTPs);
    	
    	// FP Wrong incrementer
    	projectName = "opennlp-sandbox";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "summarizer/src/main/java/opennlp/summarization/textrank/TextRankSummarizer.java";
    	shaId = "8f6c18545f9fa2ce628ef54b33a1f01bdf976b8e";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// TP Inconsistent null checker
    	/*projectName = "hadoop-common";
    	
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "hadoop-hdfs-project/hadoop-hdfs/src/main/java/org/apache/hadoop/hdfs/server/balancer/Balancer.java";
    	shaId = "9393603a21151d48354100151c08e875618cf893~1";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),++numOfTPs);
    	
    	// FP InconsistentNullChecker
    	// if (other.typeName != null) return false;
    	// ignore if the then block consists of keywords
    	
    	gitURI = projectPathRoot1 + File.separator + "apex-core";
    	path = "engine/src/main/java/com/datatorrent/stram/webapp/TypeGraph.java"; //	
    	shaId = "0631c9b98fc266d1f43ebfb21e378c3676a2af84~1";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);*/
    	
    	// TP but FP SameObjEquals incomplete code (intentionally by a developer)
    	projectName = "directory-server";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "core-api/src/main/java/org/apache/directory/server/core/schema/registries/synchronizers/SchemaSynchronizer.java";
    	shaId = "997e736670b4b6609675d1cb61a4b2a0d3a81730";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),++numOfTPs);
    	
    	// TP Equal to the same expression
    	projectName = "hadoop-common";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "src/java/org/apache/hadoop/hdfs/server/datanode/ReplicasMap.java";
    	shaId = "87c4ba830a93a782377e4c0ead9c5eca3984a41d~1";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),++numOfTPs);
    	
    	// FP  Equal to the same expression
    	projectName = "caja";
    	gitURI = projectPathRoot2 + File.separator + projectName;
    	path = "src/com/google/caja/parser/js/NumberLiteral.java";
    	shaId = "0fcdd388b0f5397a195864830f9e6ed5191c3c10~1";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP  Equal to the same expression
    	projectName = "cloudstack";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "server/src/com/cloud/server/StatsCollector.java";
    	shaId = "ad0c25fbc407893a25aa611e5fd0e9b4f6eabf48";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP  Equal to the same expression
    	// 1 == 1 would be intentionally made by developers
    	projectName = "geronimo";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "framework/buildsupport/car-maven-plugin/src/main/java/org/apache/geronimo/mavenplugins/car/PackageMojo.java";
    	shaId = "679e714ba90681d8935bea923091e6f7cbc5a701";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// TP Equal to the same expression
    	projectName = "incubator-beam";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "sdk/src/main/java/com/google/cloud/dataflow/sdk/transforms/windowing/CalendarWindows.java";
    	shaId = "a77a8ab51a4738fdf7a8345dc526a72ee2fdc13e";
 
    	numOfTPs += 3;
    	
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP SameObjEqual
    	projectName = "intellij-community";
    	gitURI = projectPathRoot3 + File.separator + projectName;
    	path = "platform/lang-impl/src/com/intellij/ide/favoritesTreeView/UsageFavoriteNodeProvider.java";
    	shaId = "f6aab90fc3febb0b5154554e66ce11c63491133e";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP SameObjEqual
    	projectName = "zuul";
    	gitURI = projectPathRoot4 + File.separator + projectName;
    	path = "zuul-netflix/src/main/java/com/netflix/zuul/stats/ErrorStatsData.java";
    	shaId = "b4c6821a0d644d467c5560da4f836c30ada0efc1";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP IllogicalCondition
    	projectName = "quasar";
    	gitURI = projectPathRoot4 + File.separator + projectName;
    	path = "quasar-actors/src/main/java/co/paralleluniverse/actors/behaviors/SupervisorActor.java";
    	shaId = "df07c60aeccf3aacc3c0bd3534d1bba01ca50b72";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP EqualToSameExpression
    	projectName = "processing";
    	gitURI = projectPathRoot5 + File.separator + projectName;
    	path = "core/src/processing/data/FloatList.java";
    	shaId = "6f6d703ed5d212beb879550783d25dd1e079f4ec";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP EqualToSameExpression
    	projectName = "GT";
    	gitURI = projectPathRoot6 + File.separator + projectName;
    	path = "android/src/com/tencent/wstt/gt/plugin/gps/GTGPSReplayEngine.java";
    	shaId = "8b42865cf09866da89c6cf95759c2bcd04fc23a6";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP EqualToSameExpression
    	projectName = "processing";
    	gitURI = projectPathRoot5 + File.separator + projectName;
    	path = "core/src/processing/core/PShape.java";
    	shaId = "6f6d703ed5d212beb879550783d25dd1e079f4ec";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP SameObjEquals
    	projectName = "CoreNLP";
    	gitURI = projectPathRoot5 + File.separator + projectName;
    	path = "src/edu/stanford/nlp/stats/GeneralizedCounter.java";
    	shaId = "1b5035edb268f05140c981f1ca94c598d66c57e9";
 
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP EqualToSameExpression cache related
    	projectName = "lucene-solr";
    	gitURI = projectPathRoot1 + File.separator + projectName;
    	path = "lucene/core/src/java/org/apache/lucene/util/RamUsageEstimator.java";
    	shaId = "517acece6a210b2d1baf75a39fe3b77ea59926b2";
    	
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP EqualToSameExpression cache related
    	projectName = "intellij-community";
    	gitURI = projectPathRoot3 + File.separator + projectName;
    	path = "java/java-analysis-impl/src/com/intellij/codeInspection/dataFlow/DfaMemoryStateImpl.java";
    	shaId = "f6aab90fc3febb0b5154554e66ce11c63491133e";
    	
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP SameObjEquals
    	projectName = "fqrouter";
    	gitURI = projectPathRoot7 + File.separator + projectName;
    	path = "android/src/net/sf/ivmaidns/dns/DNSRecord.java";
    	shaId = "2468f62cf9ec05a2271fa32a2593963952cc1682";
    	
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    	
    	// FP EqualToSameExpression
    	projectName = "FlexLayout";
    	gitURI = projectPathRoot7 + File.separator + projectName;
    	path = "library/src/com/github/mmin18/widget/FlexLayout.java";
    	shaId = "8db124c1453a0747e7fde8f9a1f8b52111d9727a";
    	
    	detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
    	assertEquals(identifiedPotentialBug.size(),numOfTPs);
    }

	private void detect(String prjName, String gitURI, String path, String shaId,HashSet<DetectionRecord> identifiedPotentialBug) {
		try {
    		Git git;
			git = Git.open( new File(gitURI) );
			Repository repo = git.getRepository();
			
			String fileSource=Utils.fetchBlob(repo, shaId, path);
			
			fileSource = Utils.removeComments(fileSource);
			
			JavaASTParser preFixWholeCodeAST = new JavaASTParser(fileSource);

			process(prjName,new RedundantException(prjName,preFixWholeCodeAST,shaId,path,repo).detect());
			process(prjName,new RedundantCondition(prjName,preFixWholeCodeAST,shaId,path,repo).detect());
			process(prjName,new RedundantInstantiation(prjName,preFixWholeCodeAST,shaId,path,repo).detect());
			process(prjName,new IllogicalCondition(prjName,preFixWholeCodeAST,shaId,path,repo).detect());
			process(prjName,new IllogicalConditionNPE(prjName,preFixWholeCodeAST,shaId,path,repo).detect());
			process(prjName,new IncorrectMapIterator(prjName,preFixWholeCodeAST,shaId,path,repo).detect());
			process(prjName,new MissingThrow(prjName,preFixWholeCodeAST,shaId,path,repo).detect());
			process(prjName,new IncorrectDirectorySlash(prjName,preFixWholeCodeAST,shaId,path,repo).detect());
			//process(prjName,new MissingTimeResolution(prjName,preFixWholeCodeAST,shaId,path,repo).detect());
			process(prjName,new WrongIncrementer(prjName,preFixWholeCodeAST,shaId,path,repo).detect());
			process(prjName,new SameObjEquals(prjName,preFixWholeCodeAST,shaId,path,repo).detect());
			// this pattern genertes to many false positives
			//process(prjName,new InconsistentNullChecker(prjName,preFixWholeCodeAST,shaId,path,repo).detect());
			process(prjName,new EqualToSameExpression(prjName,preFixWholeCodeAST,shaId,path,repo).detect());
			
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
						+ detRec.getPath());
				System.out.println(detRec.getCode() + "\n");
			}
		}
		
	}
}
