package org.example.Services;

import org.example.entities.*;
import org.example.repositories.*;
import org.example.storage.FileSaveFormat;
import org.example.storage.StorageService;
import org.springframework.stereotype.Service;
import com.github.javafaker.Faker;
import org.example.repositories.PostImageRepository;
import java.time.LocalDateTime;
import java.util.Locale;

@Service
public class DatabaseSeeder {
    private final Faker faker;
    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;
    private final PostTagRepository postTagRepository;
    private final TagRepository tagRepository;
    private final StorageService storageService;
    private final PostImageRepository postImageRepository;
    public DatabaseSeeder(CategoryRepository categoryRepository,
                          PostRepository postRepository,
                          PostTagRepository postTagRepository,
                          TagRepository tagRepository,
                          StorageService storageService,
                          PostImageRepository postImageRepository) {
        this.categoryRepository = categoryRepository;
        this.postRepository = postRepository;
        this.postTagRepository = postTagRepository;
        this.tagRepository = tagRepository;
        this.storageService = storageService;
        this.postImageRepository = postImageRepository;
        faker = new Faker(new Locale("uk"));
    }

    public void SeedAllTables() {
        seedCategories(20);
        seedTags(20);
        generatePosts(20);
        generatePostTags(40);
    }

    private void seedCategories(int n) {
        if (categoryRepository.count() < n) {
            for (int i = 0; i < n; i++) {
                CategoryEntity category = new CategoryEntity();
                category.setName(faker.commerce().department());
//                category.setUrlSlug(UrlSlugGenerator.generateUrlSlug(category.getName()));
                category.setDescription(faker.lorem().word());
                categoryRepository.save(category);
            }
        }
    }

    private void seedTags(int n) {
        if (tagRepository.count() < n) {
            for (int i = 0; i < n; i++) {
                TagEntity tag = new TagEntity();
                tag.setName(faker.lorem().word());
//                tag.setUrlSlug(UrlSlugGenerator.generateUrlSlug(tag.getName()));
//                tag.setDescription(faker.lorem().word());
                tagRepository.save(tag);
            }
        }
    }

    public void generatePosts(int count) {
        if (postRepository.count() < count) {
            var categories = categoryRepository.findAll();
            for (int i = 0; i < count; i++) {
                PostEntity post = new PostEntity();
                post.setTitle(faker.lorem().characters(10, 30));
                post.setShortDescription(faker.lorem().characters(20, 50));
//                post.setDescription(faker.lorem().characters(100, 150));
                post.setDescription("Snackbars differ from Alerts in that Snackbars have a fixed position and a high z-index, so they're intended to break out of the document flow; Alerts, on the other hand, are usually part of the flow—except when they're used as children of a Snackbar. Snackbars also from differ from Dialogs in that Snackbars are not intended to convey critical information or block the user from interacting with the rest of the app; Dialogs, by contrast, require input from the user in order to be dismissed.");

//                post.setMeta(faker.lorem().characters(20, 30));
//                post.setUrlSlug(faker.lorem().characters(5, 10));
                post.setPublished(faker.random().nextBoolean());
                post.setDateCreated(LocalDateTime.now());
                post.setCategory(categories.get(faker.random().nextInt(categories.size())));
                postRepository.save(post);


                int numberOfImages = faker.random().nextInt(1, 4); // Випадкова кількість фото від 1 до 3
                for (int j = 0; j < numberOfImages; j++) {
                    try {
                        String imageUrl = "https://picsum.photos/1200/1300";
                        String fileName = storageService.SaveImageURL(imageUrl, FileSaveFormat.WEBP);

                        PostImageEntity productImage = new PostImageEntity();
                        productImage.setName(fileName);
                        productImage.setDateCreated(LocalDateTime.now());
                        productImage.setPost(post);
                        postImageRepository.save(productImage);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }

            }
        }
    }

    public void generatePostTags(int count) {
        if (postTagRepository.count() < count) {
            var posts = postRepository.findAll();
            var tags = tagRepository.findAll();
            for (int i = 0; i < count; i++) {
                PostTagMapEntity postTag = new PostTagMapEntity();
                postTag.setTag(tags.get(faker.random().nextInt(tags.size())));
                postTag.setPost(posts.get(faker.random().nextInt(posts.size())));
                postTagRepository.save(postTag);
            }
        }
    }
}
