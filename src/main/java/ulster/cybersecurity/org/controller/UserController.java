package ulster.cybersecurity.org.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {
//
//    @Autowired
//    private AzureBlobService azureBlobService;
//    @Autowired
//    private VideoService videoService;
//
//    /*
//    @PostMapping("/upload")
//    public ResponseEntity<String> upload
//            (@RequestParam("file") MultipartFile file,
//             String description, String title,
//             String genre, String ageRating,
//             @AuthenticationPrincipal UserDetails userDetails)
//            throws IOException {
//
//        String blobUrl = azureBlobService.upload(file);
//        String currentLoggedInUsername = userDetails.getUsername();
//        String originalFilename = file.getOriginalFilename();
//
//        // Persisting video metadata to database
//        videoService.saveVideoMetadata(description, title, blobUrl, genre,
//                ageRating, originalFilename, currentLoggedInUsername);
//        return ResponseEntity.ok("Video uploaded successfully");
//    }
//
//     */
//    @GetMapping("/all-videos")
//    public ResponseEntity<?> findAllVideos(){
//        List<Map<String, String>> videos = videoService.findAll();
//        return ResponseEntity.ok(videos.get(0));
//    }
//
//    /*
//    @GetMapping("/random-video")
//    public ResponseEntity<?> generateRandomBlobUrl(){
//        Map<String, Object> randomBlob = videoService.generateRandomBlob();
//        return ResponseEntity.ok(randomBlob);
//    }
//
//
//    @GetMapping("/all-videos-by-current-user")
//    public ResponseEntity<?> findAllVideosByCurrentUser(@AuthenticationPrincipal UserDetails userDetails){
//        Map<?, ?> videosByPublisher = videoService.findAllByPublisher(userDetails.getUsername());
//        return ResponseEntity.ok(videosByPublisher);
//    }
//
//     */
//    @GetMapping("/files")
//    public ResponseEntity<List<String>> getAllBlobs() {
//        List<String> items = azureBlobService.listBlobs();
//        return ResponseEntity.ok(items);
//    }
//
//    /*
//    @GetMapping("/blobURLs")
//    public ResponseEntity<List<String>> getAllBlobURLs() {
//        List<String> items = azureBlobService.listBlobURLs();
//        return ResponseEntity.ok(items);
//    }
//
//    @DeleteMapping("/delete/{name}")
//    public ResponseEntity<Boolean> delete
//            (@PathVariable("name") String name) {
//
//        azureBlobService.deleteBlob(name);
//        videoService.deleteAllByFilename(name);
//        return ResponseEntity.ok(Boolean.TRUE);
//    }
//    */
//    @GetMapping(path = "/download/{name}")
//    public ResponseEntity<Resource> getFile
//            (@PathVariable("name") String name)
//            throws URISyntaxException {
//
//        ByteArrayResource resource =
//                new ByteArrayResource(azureBlobService
//                        .getFile(name));
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.CONTENT_DISPOSITION,
//                "attachment; filename=\"" +
//                        name + "\"");
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .headers(headers).body(resource);
//    }
//
//    /*
//    @GetMapping("/videos/{id}")
//    public ResponseEntity<?> findBlobUrlById(@PathVariable("id") Long id){
//        Map<?, ?> videoMapDetails = videoService.findVideoById(id);
//        return ResponseEntity.ok(videoMapDetails);
//    }
//
//     */
//

}
