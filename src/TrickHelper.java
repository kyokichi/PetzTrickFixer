
import java.util.ArrayList;

/**
 * TrickHelper is a basically a giant list that contains all the possible tricks from a spreadsheet.
 * @author Alexis
 */
public class TrickHelper
{
    final static Trick[] allTricks = {
        new Trick(64, 437, -1, -1, 0, Trick.Gesture.toy, Trick.Flavor.chicken, "Balance on Toy", Trick.Version.petz2, Trick.Species.dog),
        new Trick(65, -1, -1, -1, 0, Trick.Gesture.toy, Trick.Flavor.chicken, "Fetch Toy", Trick.Version.petz2, Trick.Species.both),
        new Trick(64, 438, -1, -1, 0, Trick.Gesture.toy, Trick.Flavor.chicken, "Bounce on Toy", Trick.Version.petz2, Trick.Species.dog),
        new Trick(70, 439, 440, -1, 0, Trick.Gesture.toy, Trick.Flavor.chicken, "Balance Toy on Nose", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 408, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "High Jump", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 410, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Beg", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 411, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Short Jump", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 412, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Backflip", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 409, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Side Flip", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 413, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Walk on Hind Legs", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 414, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Stand on One Leg", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 415, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Heel Click", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 416, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Jump Kick", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 417, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Headstand", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 418, 419, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Stand on Hind Legs", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 420, 421, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Handstand", Trick.Version.petz2, Trick.Species.dog),
        new Trick(69, 1, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Slide on Screen", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 422, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Cartwheel", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 423, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Sit", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 424, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Lie Down Alert", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 425, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Lie Down Rest", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 426, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Roll onto Back and Wiggle", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 427, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Wave", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 428, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Play Dead", Trick.Version.petz2, Trick.Species.dog),
        new Trick(66, 430, -1, 0, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Rollover Left", Trick.Version.petz2, Trick.Species.dog),
        new Trick(66, 432, -1, 0, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Sidestep Left", Trick.Version.petz2, Trick.Species.dog),
        new Trick(66, 434, -1, 0, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Hop Left", Trick.Version.petz2, Trick.Species.dog),
        new Trick(66, 435, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Somersault Left", Trick.Version.petz2, Trick.Species.dog),
        new Trick(66, 436, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Jump Left", Trick.Version.petz2, Trick.Species.dog),
        new Trick(69, 3, -1, -1, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Slide on Wall Left", Trick.Version.petz2, Trick.Species.dog),
        new Trick(66, 429, -1, 0, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Rollover Right", Trick.Version.petz2, Trick.Species.dog),
        new Trick(66, 431, -1, 0, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Sidestep Right", Trick.Version.petz2, Trick.Species.dog),
        new Trick(66, 433, -1, 0, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Hop Right", Trick.Version.petz2, Trick.Species.dog),
        new Trick(66, 435, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Somersault Right", Trick.Version.petz2, Trick.Species.dog),
        new Trick(66, 436, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Jump Right", Trick.Version.petz2, Trick.Species.dog),
        new Trick(69, 4, -1, -1, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Slide on Wall Right", Trick.Version.petz2, Trick.Species.dog),
        new Trick(67, 441, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Backflip", Trick.Version.petz2, Trick.Species.cat),
        new Trick(67, 442, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Bounce", Trick.Version.petz2, Trick.Species.cat),
        new Trick(67, 444, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Plead", Trick.Version.petz2, Trick.Species.cat),
        new Trick(67, 445, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Speech", Trick.Version.petz2, Trick.Species.cat),
        new Trick(67, 446, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Peekaboo", Trick.Version.petz2, Trick.Species.cat),
        new Trick(67, 450, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Jump Splat", Trick.Version.petz2, Trick.Species.cat),
        new Trick(67, 443, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Spin", Trick.Version.petz2, Trick.Species.cat),
        new Trick(67, 447, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Crouch", Trick.Version.petz2, Trick.Species.cat),
        new Trick(66, 451, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Somersault Left", Trick.Version.petz2, Trick.Species.cat),
        new Trick(66, 448, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Jump Left", Trick.Version.petz2, Trick.Species.cat),
        new Trick(66, 449, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Flying Leap Left", Trick.Version.petz2, Trick.Species.cat),
        new Trick(66, 451, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Somersault Right", Trick.Version.petz2, Trick.Species.cat),
        new Trick(66, 448, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Jump Right", Trick.Version.petz2, Trick.Species.cat),
        new Trick(66, 449, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Flying Leap Right", Trick.Version.petz2, Trick.Species.cat),
        new Trick(98, 547, -1, -1, 0, Trick.Gesture.toy, Trick.Flavor.chicken, "Balance on Toy", Trick.Version.petz3, Trick.Species.dog),
        new Trick(99, -1, -1, -1, 0, Trick.Gesture.toy, Trick.Flavor.chicken, "Fetch Toy", Trick.Version.petz3, Trick.Species.both),
        new Trick(98, 548, -1, -1, 0, Trick.Gesture.toy, Trick.Flavor.chicken, "Bounce on Toy", Trick.Version.petz3, Trick.Species.dog),
        new Trick(104, 549, 550, -1, 0, Trick.Gesture.toy, Trick.Flavor.chicken, "Balance Toy on Nose", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 518, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "High Jump", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 520, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Beg", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 521, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Short Jump", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 522, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Backflip", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 519, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Side Flip", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 523, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Walk on Hind Legs", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 524, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Stand on One Leg", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 525, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Heel Click", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 526, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Jump Kick", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 527, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Headstand", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 528, 529, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Stand on Hind Legs", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 530, 531, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Handstand", Trick.Version.petz3, Trick.Species.dog),
        new Trick(103, 1, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Slide on Screen", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 532, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Cartwheel", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 533, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Sit", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 534, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Lie Down Alert", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 535, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Lie Down Rest", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 536, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Roll onto Back and Wiggle", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 537, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Wave", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 538, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Play Dead", Trick.Version.petz3, Trick.Species.dog),
        new Trick(100, 540, -1, 0, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Rollover Left", Trick.Version.petz3, Trick.Species.dog),
        new Trick(100, 542, -1, 0, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Sidestep Left", Trick.Version.petz3, Trick.Species.dog),
        new Trick(100, 544, -1, 0, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Hop Left", Trick.Version.petz3, Trick.Species.dog),
        new Trick(100, 545, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Somersault Left", Trick.Version.petz3, Trick.Species.dog),
        new Trick(100, 546, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Jump Left", Trick.Version.petz3, Trick.Species.dog),
        new Trick(103, 3, -1, -1, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Slide on Wall Left", Trick.Version.petz3, Trick.Species.dog),
        new Trick(100, 539, -1, 0, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Rollover Right", Trick.Version.petz3, Trick.Species.dog),
        new Trick(100, 541, -1, 0, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Sidestep Right", Trick.Version.petz3, Trick.Species.dog),
        new Trick(100, 543, -1, 0, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Hop Right", Trick.Version.petz3, Trick.Species.dog),
        new Trick(100, 545, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Somersault Right", Trick.Version.petz3, Trick.Species.dog),
        new Trick(100, 546, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Jump Right", Trick.Version.petz3, Trick.Species.dog),
        new Trick(103, 4, -1, -1, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Slide on Wall Right", Trick.Version.petz3, Trick.Species.dog),
        new Trick(101, 551, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Backflip", Trick.Version.petz3, Trick.Species.cat),
        new Trick(101, 552, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Bounce", Trick.Version.petz3, Trick.Species.cat),
        new Trick(101, 554, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Plead", Trick.Version.petz3, Trick.Species.cat),
        new Trick(101, 555, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Speech", Trick.Version.petz3, Trick.Species.cat),
        new Trick(101, 556, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Peekaboo", Trick.Version.petz3, Trick.Species.cat),
        new Trick(101, 560, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Jump Splat", Trick.Version.petz3, Trick.Species.cat),
        new Trick(101, 553, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Spin", Trick.Version.petz3, Trick.Species.cat),
        new Trick(101, 557, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Crouch", Trick.Version.petz3, Trick.Species.cat),
        new Trick(100, 561, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Somersault Left", Trick.Version.petz3, Trick.Species.cat),
        new Trick(100, 558, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Jump Left", Trick.Version.petz3, Trick.Species.cat),
        new Trick(100, 559, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Flying Leap Left", Trick.Version.petz3, Trick.Species.cat),
        new Trick(100, 561, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Somersault Right", Trick.Version.petz3, Trick.Species.cat),
        new Trick(100, 558, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Jump Right", Trick.Version.petz3, Trick.Species.cat),
        new Trick(100, 559, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Flying Leap Right", Trick.Version.petz3, Trick.Species.cat),
        new Trick(100, 560, -1, -1, 0, Trick.Gesture.toy, Trick.Flavor.chicken, "Balance on Toy", Trick.Version.petz4, Trick.Species.dog),
        new Trick(101, -1, -1, -1, 0, Trick.Gesture.toy, Trick.Flavor.chicken, "Fetch Toy", Trick.Version.petz4, Trick.Species.both),
        new Trick(100, 561, -1, -1, 0, Trick.Gesture.toy, Trick.Flavor.chicken, "Bounce on Toy", Trick.Version.petz4, Trick.Species.dog),
        new Trick(106, 562, 563, -1, 0, Trick.Gesture.toy, Trick.Flavor.chicken, "Balance Toy on Nose", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 531, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "High Jump", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 533, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Beg", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 534, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Short Jump", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 535, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Backflip", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 532, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Side Flip", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 536, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Walk on Hind Legs", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 537, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Stand on One Leg", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 538, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Heel Click", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 539, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Jump Kick", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 540, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Headstand", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 541, 542, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Stand on Hind Legs", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 543, 544, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Handstand", Trick.Version.petz4, Trick.Species.dog),
        new Trick(105, 1, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Slide on Screen", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 545, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Cartwheel", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 546, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Sit", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 547, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Lie Down Alert", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 548, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Lie Down Rest", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 549, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Roll onto Back and Wiggle", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 550, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Wave", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 551, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Play Dead", Trick.Version.petz4, Trick.Species.dog),
        new Trick(102, 553, -1, 0, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Rollover Left", Trick.Version.petz4, Trick.Species.dog),
        new Trick(102, 555, -1, 0, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Sidestep Left", Trick.Version.petz4, Trick.Species.dog),
        new Trick(102, 557, -1, 0, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Hop Left", Trick.Version.petz4, Trick.Species.dog),
        new Trick(102, 558, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Somersault Left", Trick.Version.petz4, Trick.Species.dog),
        new Trick(102, 559, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Jump Left", Trick.Version.petz4, Trick.Species.dog),
        new Trick(105, 3, -1, -1, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Slide on Wall Left", Trick.Version.petz4, Trick.Species.dog),
        new Trick(102, 552, -1, 0, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Rollover Right", Trick.Version.petz4, Trick.Species.dog),
        new Trick(102, 554, -1, 0, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Sidestep Right", Trick.Version.petz4, Trick.Species.dog),
        new Trick(102, 556, -1, 0, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Hop Right", Trick.Version.petz4, Trick.Species.dog),
        new Trick(102, 558, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Somersault Right", Trick.Version.petz4, Trick.Species.dog),
        new Trick(102, 559, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Jump Right", Trick.Version.petz4, Trick.Species.dog),
        new Trick(105, 4, -1, -1, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Slide on Wall Right", Trick.Version.petz4, Trick.Species.dog),
        new Trick(103, 564, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Backflip", Trick.Version.petz4, Trick.Species.cat),
        new Trick(103, 565, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Bounce", Trick.Version.petz4, Trick.Species.cat),
        new Trick(103, 567, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Plead", Trick.Version.petz4, Trick.Species.cat),
        new Trick(103, 568, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Speech", Trick.Version.petz4, Trick.Species.cat),
        new Trick(103, 569, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Peekaboo", Trick.Version.petz4, Trick.Species.cat),
        new Trick(103, 573, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Jump Splat", Trick.Version.petz4, Trick.Species.cat),
        new Trick(103, 566, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Spin", Trick.Version.petz4, Trick.Species.cat),
        new Trick(103, 570, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Crouch", Trick.Version.petz4, Trick.Species.cat),
        new Trick(102, 574, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Somersault Left", Trick.Version.petz4, Trick.Species.cat),
        new Trick(102, 571, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Jump Left", Trick.Version.petz4, Trick.Species.cat),
        new Trick(102, 572, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Flying Leap Left", Trick.Version.petz4, Trick.Species.cat),
        new Trick(102, 574, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Somersault Right", Trick.Version.petz4, Trick.Species.cat),
        new Trick(102, 571, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Jump Right", Trick.Version.petz4, Trick.Species.cat),
        new Trick(102, 572, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Flying Leap Right", Trick.Version.petz4, Trick.Species.cat),
        new Trick(99, 560, -1, -1, 0, Trick.Gesture.toy, Trick.Flavor.chicken, "Balance on Toy", Trick.Version.petz5, Trick.Species.dog),
        new Trick(100, -1, -1, -1, 0, Trick.Gesture.toy, Trick.Flavor.chicken, "Fetch Toy", Trick.Version.petz5, Trick.Species.both),
        new Trick(99, 561, -1, -1, 0, Trick.Gesture.toy, Trick.Flavor.chicken, "Bounce on Toy", Trick.Version.petz5, Trick.Species.dog),
        new Trick(105, 562, 563, -1, 0, Trick.Gesture.toy, Trick.Flavor.chicken, "Balance Toy on Nose", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 531, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "High Jump", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 533, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Beg", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 534, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Short Jump", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 535, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Backflip", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 532, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Side Flip", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 536, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Walk on Hind Legs", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 537, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Stand on One Leg", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 538, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Heel Click", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 539, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Jump Kick", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 540, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Headstand", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 541, 542, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Stand on Hind Legs", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 543, 544, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Handstand", Trick.Version.petz5, Trick.Species.dog),
        new Trick(104, 1, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Slide on Screen", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 545, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Cartwheel", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 546, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Sit", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 547, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Lie Down Alert", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 548, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Lie Down Rest", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 549, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Roll onto Back and Wiggle", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 550, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Wave", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 551, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Play Dead", Trick.Version.petz5, Trick.Species.dog),
        new Trick(101, 553, -1, 0, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Rollover Left", Trick.Version.petz5, Trick.Species.dog),
        new Trick(101, 555, -1, 0, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Sidestep Left", Trick.Version.petz5, Trick.Species.dog),
        new Trick(101, 557, -1, 0, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Hop Left", Trick.Version.petz5, Trick.Species.dog),
        new Trick(101, 558, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Somersault Left", Trick.Version.petz5, Trick.Species.dog),
        new Trick(101, 559, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Jump Left", Trick.Version.petz5, Trick.Species.dog),
        new Trick(104, 3, -1, -1, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Slide on Wall Left", Trick.Version.petz5, Trick.Species.dog),
        new Trick(101, 552, -1, 0, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Rollover Right", Trick.Version.petz5, Trick.Species.dog),
        new Trick(101, 554, -1, 0, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Sidestep Right", Trick.Version.petz5, Trick.Species.dog),
        new Trick(101, 556, -1, 0, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Hop Right", Trick.Version.petz5, Trick.Species.dog),
        new Trick(101, 558, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Somersault Right", Trick.Version.petz5, Trick.Species.dog),
        new Trick(101, 559, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Jump Right", Trick.Version.petz5, Trick.Species.dog),
        new Trick(104, 4, -1, -1, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Slide on Wall Right", Trick.Version.petz5, Trick.Species.dog),
        new Trick(102, 564, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Backflip", Trick.Version.petz5, Trick.Species.cat),
        new Trick(102, 565, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Bounce", Trick.Version.petz5, Trick.Species.cat),
        new Trick(102, 567, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Plead", Trick.Version.petz5, Trick.Species.cat),
        new Trick(102, 568, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Speech", Trick.Version.petz5, Trick.Species.cat),
        new Trick(102, 569, -1, -1, 0, Trick.Gesture.up, Trick.Flavor.chicken, "Peekaboo", Trick.Version.petz5, Trick.Species.cat),
        new Trick(102, 573, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Jump Splat", Trick.Version.petz5, Trick.Species.cat),
        new Trick(102, 566, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Spin", Trick.Version.petz5, Trick.Species.cat),
        new Trick(102, 570, -1, -1, 0, Trick.Gesture.down, Trick.Flavor.chicken, "Crouch", Trick.Version.petz5, Trick.Species.cat),
        new Trick(101, 574, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Somersault Left", Trick.Version.petz5, Trick.Species.cat),
        new Trick(101, 571, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Jump Left", Trick.Version.petz5, Trick.Species.cat),
        new Trick(101, 572, -1, 64, 0, Trick.Gesture.left, Trick.Flavor.chicken, "Flying Leap Left", Trick.Version.petz5, Trick.Species.cat),
        new Trick(101, 574, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Somersault Right", Trick.Version.petz5, Trick.Species.cat),
        new Trick(101, 571, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Jump Right", Trick.Version.petz5, Trick.Species.cat),
        new Trick(101, 572, -1, -64, 0, Trick.Gesture.right, Trick.Flavor.chicken, "Flying Leap Right", Trick.Version.petz5, Trick.Species.cat)
    };
    
    public static ArrayList<Trick> getTricks(Trick.Version version, Trick.Gesture gesture, Trick.Species species)
    {
        ArrayList<Trick> tricks = new ArrayList<Trick>();
        
        for(Trick z : allTricks)
        {
            if(z.ver == version && z.gesture == gesture && z.species == species)
            {
                tricks.add(z);
            }
        }
        
        return tricks;
    }
    
    public static Trick getTrickBy(Trick.Version version, Trick.Gesture gesture, Trick.Species species)
    {
        for(Trick z : allTricks)
        {
            if(z.ver == version && z.gesture == gesture && z.species == species)
            {
                return z;
            }
        }
        
        return null;
    }
    
    public static Trick getTrickBy(int plan, int action, Trick.Gesture gesture)
    {
        for(Trick z : allTricks)
        {
            if(z.plan == plan && z.action == action && z.gesture == gesture)
            {
                return z;
            }
        }
        
        return null;
    }
    
    public static Trick getTrickBy(String name, Trick.Version ver, Trick.Species spe)
    {
        for(Trick z : allTricks)
        {
            if(z.name.equals(name) && z.ver == ver 
                    && (z.species == spe || z.species == Trick.Species.both))
            {
                return z;
            }
        }
        
        return null;
    }
}
