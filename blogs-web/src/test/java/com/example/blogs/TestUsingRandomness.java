package com.example.blogs;

import com.carrotsearch.randomizedtesting.RandomizedTest;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.MockAnalyzer;
import org.apache.lucene.analysis.MockTokenizer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.LuceneTestCase;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by puhui on 2017-09-12.
 */
public class TestUsingRandomness extends RandomizedTest {
    @Test
    public void expectNoException() {
        String[] words = { "oh", "my", "this", "is", "bad." };

        // 这将从上面的数组中选出一个随机词
        System.out.println(words[Math.abs(super.randomInt()) % words.length]);
    }
    public static void test1() throws IOException {
        Analyzer analyzer = new MockAnalyzer(LuceneTestCase.random(),
                MockTokenizer.SIMPLE, true);
        Directory rd = new RAMDirectory();
        IndexWriter w = new IndexWriter(rd, new IndexWriterConfig(analyzer));
    }
}
