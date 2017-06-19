package ca.uwaterloo.ece.feedet;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.junit.Test;

import ca.uwaterloo.ece.feedet.DetectionRecord;
import ca.uwaterloo.ece.feedet.bugpatterns.WrongLogicForNullChecker;
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
public class TestBugPatternWrongLogicForNullChcker {

	HashSet<DetectionRecord> identifiedPotentialBug = new HashSet<DetectionRecord>();

	@Test public void testSomeLibraryMethod() {

		String projectPathRoot1 = System.getProperty("user.home") + "/Documents/githubProjects/apache"; //System.getProperty("user.home") + "/X"; // "/Volumes/Faith/githubProjects/apache"; //System.getProperty("user.home") + "/Documents/githubProjects/apache";
		String projectPathRoot2 = System.getProperty("user.home") + "/Documents/githubProjects/google";

		int numOfTPs = 0;

		// TP hbase-server/src/main/java/org/apache/hadoop/hbase/regionserver/wal/ProtobufLogReader.java a90a187d484445823cbbd9987f0329e1dbe68ce4~1
		// realEofEx != null ? ex : realEofEx
		String projectName = "hbase";
		String gitURI = projectPathRoot1 + File.separator + projectName;
		String path = "hbase-server/src/main/java/org/apache/hadoop/hbase/regionserver/wal/ProtobufLogReader.java";
		String shaId = "a90a187d484445823cbbd9987f0329e1dbe68ce4~1";

		detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
		assertEquals(++numOfTPs,identifiedPotentialBug.size());    

		// FP iosched   c6531a72a84501db79e89647986e69345caa2808        android/src/main/java/com/google/samples/apps/iosched/explore/data/ItemGroup.java
		// 79 mId != null ? mId.equals(itemGroup.mId) : itemGroup.mId == null
		projectName = "iosched";
		gitURI = projectPathRoot2 + File.separator + projectName;
		path = "android/src/main/java/com/google/samples/apps/iosched/explore/data/ItemGroup.java";
		shaId = "c6531a72a84501db79e89647986e69345caa2808";
		
		detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
		assertEquals(numOfTPs,identifiedPotentialBug.size());
		
		// FP cassandra    cd5aacc83bc3ee2b412c191a8ce711b0401bf55a        src/java/org/apache/cassandra/service/StorageService.java
		// 1133    tokens == null ? "(All tokens)" : tokens
		projectName = "cassandra";
		gitURI = projectPathRoot1 + File.separator + projectName;
		path = "src/java/org/apache/cassandra/service/StorageService.java";
		shaId = "cd5aacc83bc3ee2b412c191a8ce711b0401bf55a";
		
		detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
		assertEquals(numOfTPs,identifiedPotentialBug.size());
		
		// FP cassandra       a2e2c03435d453306446d19c1000a95089fd8d22        a6cd2727d02a88a10c910b4b62267aba82367efd        src/java/org/apache/cassandra/service/StorageLoadBalancer.java
		// 173     instance_ == null ? (instance_=new StorageLoadBalancer()) : instance_
		projectName = "cassandra";
		gitURI = projectPathRoot1 + File.separator + projectName;
		path = "src/java/org/apache/cassandra/service/StorageLoadBalancer.java";
		shaId = "a6cd2727d02a88a10c910b4b62267aba82367efd";
		
		detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
		assertEquals(numOfTPs,identifiedPotentialBug.size());
		
		// FP cassandra       ca40d11c72225d036f864d40c251a74e0803fdc2        3623ea437ee4b22f450a25e670cffe6c00001cb0        src/java/org/apache/cassandra/config/CFMetaData.java
		// 1657    comment == null ? DeletedColumn.create(ldt,timestamp,cfName,"comment") : Column.create(comment,timestamp,cfName,"comment")
		projectName = "cassandra";
		gitURI = projectPathRoot1 + File.separator + projectName;
		path = "src/java/org/apache/cassandra/config/CFMetaData.java";
		shaId = "3623ea437ee4b22f450a25e670cffe6c00001cb0";
		
		detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
		assertEquals(numOfTPs,identifiedPotentialBug.size());
		
		// FP windowtester    Alive   3e98c40ebbf5931a0d3f9b7a3f4a1e17263c5e53        com.windowtester.runtime/abbot/src/abbot/script/ComponentReference.java
		// 718     id != null ? id : (cname + " (no id yet)")
		projectName = "windowtester";
		gitURI = projectPathRoot2 + File.separator + projectName;
		path = "com.windowtester.runtime/abbot/src/abbot/script/ComponentReference.java";
		shaId = "3e98c40ebbf5931a0d3f9b7a3f4a1e17263c5e53";
		
		detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
		assertEquals(numOfTPs,identifiedPotentialBug.size());
		
		// FP hive    Alive   70842969439a495a14b2534ba4f301660233569f        accumulo-handler/src/java/org/apache/hadoop/hive/accumulo/LazyAccumuloMap.java
		// 133     v == null ? v : v.getObject()
		// Q2
		projectName = "hive";
		gitURI = projectPathRoot1 + File.separator + projectName;
		path = "accumulo-handler/src/java/org/apache/hadoop/hive/accumulo/LazyAccumuloMap.java";
		shaId = "70842969439a495a14b2534ba4f301660233569f";
		
		detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
		assertEquals(numOfTPs,identifiedPotentialBug.size());
		
		// FP hive    Alive   adbc0ab6aeff848dbcee83d565febd40797300c2        spark-client/src/main/java/org/apache/hive/spark/client/rpc/KryoMessageCodec.java
		// 99      msg != null ? msg.getClass().getName() : msg
		projectName = "hive";
		gitURI = projectPathRoot1 + File.separator + projectName;
		path = "spark-client/src/main/java/org/apache/hive/spark/client/rpc/KryoMessageCodec.java";
		shaId = "adbc0ab6aeff848dbcee83d565febd40797300c2";
		
		detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
		assertEquals(numOfTPs,identifiedPotentialBug.size());
		
		// FP WrongLogicForNullChecker        error-prone-javac       path_deleted    55ef15a9c31c57b6ab1f53d0196e96f9224e4651        src/share/classes/com/sun/tools/javac/comp/Resolve.java 746
		// trees != null ? trees.tail : trees
		projectName = "error-prone-javac";
		gitURI = projectPathRoot2 + File.separator + projectName;
		path = "src/share/classes/com/sun/tools/javac/comp/Resolve.java";
		shaId = "55ef15a9c31c57b6ab1f53d0196e96f9224e4651";
		
		detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
		assertEquals(numOfTPs,identifiedPotentialBug.size());
		
		// FP google-authenticator    Alive   6649dd33687c5561663fb242a05f6949cf4d543f        mobile/blackberry/src/com/google/authenticator/blackberry/Uri.java
		// 1053    ssp == null ? ssp=Part.fromEncoded(makeSchemeSpecificPart()) : ssp
		projectName = "google-authenticator";
		gitURI = projectPathRoot2 + File.separator + projectName;
		path = "mobile/blackberry/src/com/google/authenticator/blackberry/Uri.java";
		shaId = "6649dd33687c5561663fb242a05f6949cf4d543f";
		
		detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
		assertEquals(numOfTPs,identifiedPotentialBug.size());
		
		//  j2objc  Alive   277e7dcb5d90374ca61920b39f6dcc17250d3c03        xalan/third_party/android/platform/external/apache-xml/src/main/java/org/apache/xalan/templates/FuncDocument.java
		// 364     uri == null ? ((base == null) ? "" : base) + uri : uri.toString()
		projectName = "j2objc";
		gitURI = projectPathRoot2 + File.separator + projectName;
		path = "xalan/third_party/android/platform/external/apache-xml/src/main/java/org/apache/xalan/templates/FuncDocument.java";
		shaId = "277e7dcb5d90374ca61920b39f6dcc17250d3c03";
		
		detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
		assertEquals(numOfTPs,identifiedPotentialBug.size());
		
		// FP geode   Alive   09d7b5ce2817bcd1ae7e7b09f32dce995b9cfcf5        geode-core/src/main/java/org/apache/geode/management/internal/web/util/UriUtils.java
		// 180     value != null ? URLEncoder.encode(value,encoding) : value
		// intentionally load null to return null
		projectName = "geode";
		gitURI = projectPathRoot1 + File.separator + projectName;
		path = "geode-core/src/main/java/org/apache/geode/management/internal/web/util/UriUtils.java";
		shaId = "09d7b5ce2817bcd1ae7e7b09f32dce995b9cfcf5";
		
		detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
		assertEquals(numOfTPs,identifiedPotentialBug.size());
		
		// Exception 8a6a7cb6695093783346a3f88ff854cfff25a6db~1
		projectName = "ignite";
		gitURI = projectPathRoot1 + File.separator + projectName;
		path = "modules/core/src/main/java/org/apache/ignite/spi/discovery/tcp/TcpDiscoverySpi.java";
		shaId = "8a6a7cb6695093783346a3f88ff854cfff25a6db";
		
		detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
		assertEquals(numOfTPs,identifiedPotentialBug.size());
		
		// Exception usergrid 021fcba68c013414261f3e123d7ec6db8dc938fe
		// Path stack/core/src/main/java/org/apache/usergrid/batch/job/OnlyOnceJob.java
		projectName = "usergrid";
		gitURI = projectPathRoot1 + File.separator + projectName;
		path = "stack/core/src/main/java/org/apache/usergrid/batch/job/OnlyOnceJob.java";
		shaId = "021fcba68c013414261f3e123d7ec6db8dc938fe";
		
		detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
		assertEquals(numOfTPs,identifiedPotentialBug.size());
		
		// FP ignite	011d925a976b47278eb3d531e1834c6ae321c142	376eb293361a1771a43d79a259cbee3d09d26767	modules/core/src/main/java/org/apache/ignite/internal/processors/cache/transactions/IgniteTxManager.java	
		// 632	tx != null ? (T)tx : (T)tx(Thread.currentThread().getId())
		projectName = "ignite";
		gitURI = projectPathRoot1 + File.separator + projectName;
		path = "modules/core/src/main/java/org/apache/ignite/internal/processors/cache/transactions/IgniteTxManager.java";
		shaId = "376eb293361a1771a43d79a259cbee3d09d26767";
		
		detect(projectName,gitURI, path, shaId,identifiedPotentialBug);
		assertEquals(numOfTPs,identifiedPotentialBug.size());
		
		// FP cocoon	74e8b8e0ff1c4fc23b6b63b4e064522098c273d3	0fd1fb636739c167c94f9f098dd5102e9db86ef8	core/cocoon-core/src/main/java/org/apache/cocoon/components/modules/input/LocateResource.java
		// 180	result == null ? result : result + filename
		projectName = "cocoon";
		gitURI = projectPathRoot1 + File.separator + projectName;
		path = "core/cocoon-core/src/main/java/org/apache/cocoon/components/modules/input/LocateResource.java";
		shaId = "0fd1fb636739c167c94f9f098dd5102e9db86ef8";
		
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

			process(prjName,new WrongLogicForNullChecker(prjName,preFixWholeCodeAST,shaId,path,repo).detect());

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
